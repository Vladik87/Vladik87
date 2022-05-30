package storage;

import dto.User;

import java.util.Optional;

public interface UserRepo {

    Optional<User> findByUserName(final String userName);
    User save(User user);
}
