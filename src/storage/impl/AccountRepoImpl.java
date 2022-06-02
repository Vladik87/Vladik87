package storage.impl;

import converter.AccountConverter;
import dto.Account;
import logger.Logger;
import storage.AccountRepo;

import java.io.*;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class AccountRepoImpl implements AccountRepo {

    private static final Logger log = Logger.getInstance();
    private static final String ACCOUNTS_FILE = "D:\\Bank\\Bank\\resources\\account.cvs";

    private static AccountRepo instance;

    private AtomicLong accountIdCounter;

    private AccountRepoImpl() {
        try (FileReader fileReader = new FileReader(ACCOUNTS_FILE);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            OptionalLong maxAccountId = bufferedReader.lines()
                    .map(line -> line.split(",")[0]) // first element is id
                    .mapToLong(Long::parseLong)
                    .max();
            if (maxAccountId.isPresent()) {
                accountIdCounter = new AtomicLong(maxAccountId.getAsLong());
                log.debug(this.getClass(), "Created accountIdCounter with initial value: %d".formatted(accountIdCounter.get()));
            } else {
                accountIdCounter = new AtomicLong();
                log.debug(this.getClass(), "Created empty accountIdCounter started with 0");
            }
        } catch (IOException e) {
            log.error(this.getClass(), e.getMessage());
        }
    }

    public static AccountRepo getInstance() {
        if (instance == null) {
            instance = new AccountRepoImpl();
        }
        return instance;
    }

    @Override
    public Optional<Account> findById(final Long id) {
        try (FileReader reader = new FileReader(ACCOUNTS_FILE);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            return bufferedReader.lines()
                    .filter(line -> line.split(",")[0].equals(id.toString())) // first element is id
                    .map(AccountConverter::toObject)
                    .findFirst();
        } catch (IOException e) {
            log.error(this.getClass(), e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<Account> findByUserId(final Long userId) {
        try (FileReader reader = new FileReader(ACCOUNTS_FILE);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            return bufferedReader.lines()
                    .filter(line -> line.split(",")[2].equals(userId.toString())) // third element is user id
                    .map(AccountConverter::toObject)
                    .findFirst();
        } catch (IOException e) {
            log.error(this.getClass(), e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Account save(final Account account) {
        if (account.getId() == null) {
            return insert(account);
        } else {
            return update(account);
        }
    }

    private Account insert(final Account account) {
        try (FileWriter fileWriter = new FileWriter(ACCOUNTS_FILE, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
             PrintWriter printWriter = new PrintWriter(bufferedWriter)) {

            long newAccountId = accountIdCounter.incrementAndGet();
            log.debug(this.getClass(), "Generated new accountIdCounter value: %d".formatted(newAccountId));
            account.setId(newAccountId);
            String csvString = AccountConverter.toCsvString(account);
            printWriter.println(csvString);
            log.debug(this.getClass(), "Saved new Account \"%s\"".formatted(csvString));
            return account;
        } catch (IOException e) {
            log.error(this.getClass(), e.getMessage());
            return null;
        }
    }

    private Account update(final Account account) {
        try (FileReader reader = new FileReader(ACCOUNTS_FILE);
             BufferedReader bufferedReader = new BufferedReader(reader)) {

            List<String> lines = bufferedReader.lines().collect(Collectors.toList());
            int updateLineIndex = -1;
            for (int i = 0; i < lines.size(); i++) {
                if (lines.get(i).split(",")[0].equals(account.getId().toString())) {
                    updateLineIndex = i;
                }
            }

            String csvString = AccountConverter.toCsvString(account);
            if (updateLineIndex != -1) {
                lines.remove(updateLineIndex);
                lines.add(updateLineIndex, csvString);
            }


            try (FileWriter writer = new FileWriter(ACCOUNTS_FILE);
                 BufferedWriter bufferedWriter = new BufferedWriter(writer);
                 PrintWriter printWriter = new PrintWriter(bufferedWriter)) {
                lines.forEach(printWriter::println);
            }
            log.debug(this.getClass(), "Updated Account \"%s\"".formatted(csvString));

            return account;
        } catch (IOException e) {
            log.error(this.getClass(), e.getMessage());
            return null;
        }
    }
}
