package ui;

import dto.Account;
import dto.User;
import exception.BackToPreviousMenuException;
import exception.ExitAppException;
import logger.Logger;
import service.AccountService;
import service.UserService;
import service.UserValidationRequest;
import service.UserValidationResult;
import session.Session;

import java.util.Scanner;

public class UI {

    private final Session session = Session.getInstance();
    private final UserService userService = UserService.getInstance();
    private final AccountService accountService = AccountService.getInstance();
    private final Scanner scanner = new Scanner(System.in);
    private final Logger log = Logger.getInstance();

    public void loginLoop() {
        while (true) {
            System.out.println("Добро пожаловать в систему. Войдите или зарегистрируйтесь");
            System.out.println("1 Войти");
            System.out.println("2 Зарегистрироваться");
            System.out.println("0 Завершить работу");

            int loginChoose = scanner.nextInt();
            switch (loginChoose) {
                case 1: {
                    System.out.println("Введите логин");
                    String userName = scanner.next();
                    System.out.println("Введите пароль");
                    String password = scanner.next();
                    User loginResult = userService.checkLogin(userName, password);
                    if (loginResult == null) {
                        System.out.println("Неверные данные, проверьте и повторите");
                        log.info(this.getClass(), "Введены неверные данные");
                        break;
                    } else {
                        System.out.printf("Добро пожаловать в систему, %s%n", loginResult.getFirstName());
                        session.createSession(loginResult);
                        log.info(this.getClass(), "Успешный вход для %s".formatted(loginResult.getUserName()));
                        return;
                    }
                }
                case 2: {
                    System.out.println("Введите логин");
                    String userName = scanner.next();
                    System.out.println("Введите пароль");
                    String password = scanner.next();
                    System.out.println("Введите имя");
                    String firstName = scanner.next();
                    System.out.println("Введите фамилию");
                    String lastName = scanner.next();
                    System.out.println("Введите дату рождения");
                    String birthDate = scanner.next();
                    System.out.println("Введите пол");
                    String sex = scanner.next();
                    System.out.println("Введите email");
                    String email = scanner.next();

                    UserValidationRequest request = new UserValidationRequest(userName, password, firstName,
                            lastName, birthDate, sex, email);
                    UserValidationResult result = userService.validate(request);

                    if (result.isSuccess()) {
                        User user = userService.create(request);
                        session.createSession(user);
                        System.out.printf("Добро пожаловать в систему, %s \n", user.getFirstName());
                        return;
                    } else {
                        System.out.println("Ошибка при создании пользователя. \n" + result.getValidationMessage());
                        continue;
                    }
                }
                case 0:
                    throw new ExitAppException();
            }
        }
    }

    public void mainLoop() {
        while (true) {
            System.out.println("1 Операции со счетом");
            System.out.println("0 Завершить работу");

            int mainChoose = scanner.nextInt();
            switch (mainChoose) {
                case 1: {
                    try {
                        accountOperationsLoop();
                    } catch (BackToPreviousMenuException e) {
                        break;
                    }
                }
                case 0:
                    throw new ExitAppException();
            }
        }
    }

    public void accountOperationsLoop() {
        while (true) {
            System.out.println("1 Проверить баланс");
            System.out.println("2 Снять деньги");
            System.out.println("3 Пополнить счет");
            System.out.println("4 Перевод по номеру счета");
            System.out.println("5 Создать счет");
            System.out.println("0 Вернуться к предыдущему меню");

            int accountOpsChoose = scanner.nextInt();
            switch (accountOpsChoose) {
                case 1: {
                    Account account = session.getUser().getAccount();
                    if (account == null) {
                        System.out.println("Отсутствует счет. Создайте счет\n");
                        break;
                    }
                    System.out.printf("Баланс: %d%n", account.getAmount());
                    System.out.println();
                    break;
                }
                case 2: {
                    Account account = session.getUser().getAccount();
                    if (account == null) {
                        System.out.println("Отсутствует счет. Создайте счет\n");
                        break;
                    }

                    System.out.println("Введите количество денег для снятия");
                    int requestedAmount = scanner.nextInt();
                    boolean withdrawResult = accountService.withdraw(session.getUser(), requestedAmount);
                    if (withdrawResult) {
                        System.out.println("Возьмите деньги\n");
                    } else {
                        System.out.println("Недостаточно средств\n");
                    }
                    break;
                }
                case 3: {
                    Account account = session.getUser().getAccount();
                    if (account == null) {
                        System.out.println("Отсутствует счет. Создайте счет\n");
                        break;
                    }
                    System.out.println("Введите деньги");
                    int putAmount = scanner.nextInt();
                    boolean putResult = accountService.put(session.getUser(), putAmount);
                    if (putResult) {
                        System.out.println("Успешно\n");
                    } else {
                        System.out.println("Слишком много средств. Налоговая извещена\n");
                    }
                    break;
                }
                case 4: {
                    Account account = session.getUser().getAccount();
                    if (account == null) {
                        System.out.println("Отсутствует счет. Создайте счет\n");
                        break;
                    }
                    System.out.println("Введите номер целевого счета");
                    long targetAccNumber = scanner.nextLong();
                    System.out.println("Введите объем переводимых денег");
                    int requestedAmount = scanner.nextInt();
                    boolean transferResult = accountService.transfer(session.getUser(), targetAccNumber, requestedAmount);
                    if (transferResult) {
                        System.out.println("Успешно\n");
                    } else {
                        System.out.println("Недостаточно или слишком много средств, или указан неверный целевой счет\n");
                    }
                    break;
                }
                case 5: {
                    if (session.getUser().getAccount() != null) {
                        System.out.println("Счет уже существует\n");
                        break;
                    }
                    accountService.createAccount(session.getUser());
                    System.out.println("Счет создан\n");
                    break;
                }
                case 0:
                    throw new BackToPreviousMenuException();
            }
        }
    }

}
