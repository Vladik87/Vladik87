package ui;

import dto.User;
import exception.ExitAppException;
import logger.Logger;
import service.UserService;
import service.UserValidationRequest;
import service.UserValidationResult;
import session.Session;

import java.util.Scanner;

public class UI {

    private final Session session = Session.getInstance();
    private final UserService userService = UserService.getInstance();
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
                    System.out.println("==Uniplemented==");
                    continue;
                }
                case 0:
                    throw new ExitAppException();
            }
        }
    }

}
