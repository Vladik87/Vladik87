package service;

import dto.Account;
import dto.User;
import logger.Logger;
import storage.AccountRepo;
import storage.impl.AccountRepoImpl;

import java.util.Optional;

public class AccountService {


    private static AccountService instance;
    private static final Logger logger = Logger.getInstance();
    private final AccountRepo accountRepo = AccountRepoImpl.getInstance();

    private AccountService() {}

    public static AccountService getInstance() {
        if (instance == null) {
            instance = new AccountService();
        }
        return instance;
    }


    public void createAccount(final User user) {
        Account account = accountRepo.save(new Account(0, user.getId()));
        user.setAccount(account);
        logger.info(this.getClass(), "Создан счет для пользователя %d".formatted(user.getId()));
    }

    // снять деньги
    public boolean withdraw(final User user, final int requestedAmount) {
        if (user.getAccount().getAmount() < requestedAmount) {
            logger.info(this.getClass(), "Недостаточно средств у пользователя %d".formatted(user.getId()));
            return false;
        }
        Integer actualAmount = user.getAccount().getAmount();
        user.getAccount().setAmount(actualAmount - requestedAmount);
        accountRepo.save(user.getAccount());
        logger.info(this.getClass(), "Снято %d со счета %d у пользователя %d".formatted(requestedAmount, user.getAccount().getId(), user.getId()));
        return true;
    }

    //положить деньги
    public boolean put(final User user, final int putAmount) {
        if (Integer.toUnsignedLong(user.getAccount().getAmount() + putAmount) >= Integer.MAX_VALUE) {
            return false;
        }

        Integer actualAmount = user.getAccount().getAmount();
        user.getAccount().setAmount(actualAmount + putAmount);
        accountRepo.save(user.getAccount());
        logger.info(this.getClass(), "Внесено %d на счет %d  пользователя %d".formatted(putAmount, user.getAccount().getId(), user.getId()));
        return true;
    }

    //перевод по номеру счета
    public boolean transfer(final User user, final Long targetAccNumber, final int requestedAmount) {
        Optional<Account> sourceAccount = accountRepo.findById(user.getAccount().getId());
        Optional<Account> targetAccount = accountRepo.findById(targetAccNumber);
        if (targetAccount.isEmpty() || sourceAccount.isEmpty()){
            return false;
        }
        if (sourceAccount.get().getAmount() < requestedAmount) {
            return false;
        }
        if ((targetAccount.get().getAmount() + requestedAmount) >= Integer.MAX_VALUE) {
            return false;
        }

        Integer actualSourceAmount = sourceAccount.get().getAmount();
        sourceAccount.get().setAmount(actualSourceAmount - requestedAmount);

        Integer actualTargetAmount = targetAccount.get().getAmount();
        targetAccount.get().setAmount(actualTargetAmount + requestedAmount);

        user.setAccount(sourceAccount.get());

        accountRepo.save(sourceAccount.get());
        accountRepo.save(targetAccount.get());
        return true;
    }
}
