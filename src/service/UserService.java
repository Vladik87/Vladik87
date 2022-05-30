package service;

import converter.UserConverter;
import dto.User;
import storage.UserRepo;
import storage.impl.UserRepoImpl;

import java.util.Optional;

public class UserService {

    private static UserService instance;

    private final UserRepo userRepo = UserRepoImpl.getInstance();
    private final UserValidator userValidator = UserValidator.getInstance();

    private UserService() {}

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public User checkLogin(final String usernameInput, final String passwordInput) {
        String username = usernameInput.trim();
        String password = passwordInput.trim();
        Optional<User> userOptional = userRepo.findByUserName(username);
        if (userOptional.isPresent()) {
            if (userOptional.get().getPassword().equals(password)) {
                return userOptional.get();
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public UserValidationResult validate(final UserValidationRequest request) {
        if (userRepo.findByUserName(request.userName()).isPresent()) {
            UserValidationResult nonUniqueUserName = new UserValidationResult();
            nonUniqueUserName.addError("Этот логин занят");
            return nonUniqueUserName;
        }
        return userValidator.validate(request);
    }

    public User create(final UserValidationRequest request) {
        User newUser = UserConverter.toObject(request);
        newUser = userRepo.save(newUser);
        return newUser;
    }
}
