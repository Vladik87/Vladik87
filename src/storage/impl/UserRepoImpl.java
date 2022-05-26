package storage.impl;

import convertor.UserConverter;
import dto.User;
import logger.Logger;

import java.io.*;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class UserRepoImpl implements UserRepo {

    private static final Logger log = Logger.getInstance();
    private final static String USERS_FILE = "./resources/users.csv";
    private static UserRepo instance;

    private AtomicLong userIdCounter;

    private UserRepoImpl() {
        try (FileReader fileReader = new FileReader(USERS_FILE);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            OptionalLong maxUserId = bufferedReader.lines()
                    .map(line -> line.split(",")[0]) // first element is id
                    .mapToLong(Long::parseLong)
                    .max();
            if (maxUserId.isPresent()) {
                userIdCounter = new AtomicLong(maxUserId.getAsLong());
                log.debug(this.getClass(), "Created UserIdCounter with initial value: %d".formatted(userIdCounter.get()));
            } else {
                userIdCounter = new AtomicLong();
                log.debug(this.getClass(), "Created empty UserIdCounter started with 0");
            }
        } catch (IOException e) {
            e.printStackTrace();
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
            return bufferedReader.lines()
                    .filter(line -> line.split(",")[1].equals(userName)) // second element is username
                    .map(UserConverter::toObject)
                    .findFirst();
        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public void save(final User user) {
        if (user.getId() == null) {
            insert(user);
        } else {
            update(user);
        }
    }

    private void insert(final User user) {
        try (FileWriter fileWriter = new FileWriter(USERS_FILE, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
             PrintWriter printWriter = new PrintWriter(bufferedWriter)) {

            long newUserId = userIdCounter.incrementAndGet();
            log.debug(this.getClass(), "Generated new UserIdCounter value: %d".formatted(newUserId));
            user.setId(newUserId);
            String csvString = UserConverter.toCsvString(user);
            printWriter.println(csvString);
            log.debug(this.getClass(), "Saved new User \"%s\"".formatted(csvString));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void update(final User user) {
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

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
