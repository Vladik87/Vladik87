package storage.impl;

import converter.UserConverter;
import dto.User;
import logger.Logger;
import storage.AccountRepo;
import storage.UserRepo;

import java.io.*;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class UserRepoImpl implements UserRepo {

    // TODO Можно сделать кэш юзеров при старте

    private static final Logger log = Logger.getInstance();
    private static final String USERS_FILE = "D:\\Bank\\Bank\\resources\\users.csv";
    private static final AccountRepo accountRepo = AccountRepoImpl.getInstance();
    private static UserRepo instance;

    private AtomicLong userIdCounter;

    private UserRepoImpl() {
        try (FileReader fileReader = new FileReader(USERS_FILE);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            OptionalLong maxUserId = bufferedReader.lines()
                    .map(line -> line.split(",")[0]) // first element is id
                    .mapToLong(java.lang.Long::parseLong)
                    .max();
            if (maxUserId.isPresent()) {
                userIdCounter = new AtomicLong(maxUserId.getAsLong());
                log.debug(this.getClass(), "Created UserIdCounter with initial value: %d".formatted(userIdCounter.get()));
            } else {
                userIdCounter = new AtomicLong();
                log.debug(this.getClass(), "Created empty UserIdCounter started with 0");
            }
        } catch (IOException e) {
            log.error(this.getClass(), e.getMessage());
        }
    }

    public static UserRepo getInstance() {
        if (instance == null) {
            instance = new UserRepoImpl();
        }
        return instance;
    }

    @Override
    public Optional<User> findByUserName(final String userName) {
        try (FileReader reader = new FileReader(USERS_FILE);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            Optional<User> userOptional = bufferedReader.lines()
                    .filter(line -> line.split(",")[1].equals(userName)) // second element is username
                    .map(UserConverter::toObject)
                    .findFirst();

            userOptional.ifPresent(u -> u.setAccount(accountRepo.findByUserId(u.getId()).orElse(null)));

            return userOptional;
        } catch (IOException e) {
            log.error(this.getClass(), e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public User save(final User user) {
        if (user.getId() == null) {
            return insert(user);
        } else {
            return update(user);
        }
    }

    private User insert(final User user) {
        try (FileWriter fileWriter = new FileWriter(USERS_FILE, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
             PrintWriter printWriter = new PrintWriter(bufferedWriter)) {

            long newUserId = userIdCounter.incrementAndGet();
            log.debug(this.getClass(), "Generated new UserIdCounter value: %d".formatted(newUserId));
            user.setId(newUserId);
            String csvString = UserConverter.toCsvString(user);
            printWriter.println(csvString);
            log.debug(this.getClass(), "Saved new User \"%s\"".formatted(csvString));
            return user;
        } catch (IOException e) {
            log.error(this.getClass(), e.getMessage());
            return null;
        }
    }

    private User update(final User user) {
        try (FileReader reader = new FileReader(USERS_FILE);
             BufferedReader bufferedReader = new BufferedReader(reader)) {

            List<String> lines = bufferedReader.lines().collect(Collectors.toList());
            int updateLineIndex = -1;
            for (int i = 0; i < lines.size(); i++) {
                if (lines.get(i).split(",")[0].equals(user.getId().toString())) {
                    updateLineIndex = i;
                }
            }

            String csvString = UserConverter.toCsvString(user);
            if (updateLineIndex != -1) {
                lines.remove(updateLineIndex);
                lines.add(updateLineIndex, csvString);
            }


            try (FileWriter writer = new FileWriter(USERS_FILE);
                 BufferedWriter bufferedWriter = new BufferedWriter(writer);
                 PrintWriter printWriter = new PrintWriter(bufferedWriter)) {
                lines.forEach(printWriter::println);
            }
            log.debug(this.getClass(), "Updated User \"%s\"".formatted(csvString));

            return user;
        } catch (IOException e) {
            log.error(this.getClass(), e.getMessage());
            return null;
        }
    }
}
