package ui;

import java.util.Scanner;

public class Ui {
    private Scanner scanner = new Scanner(System.in);

    public void loginLoop() {
        while (true) {
            System.out.println(" Добро пожаловать в систему. Воидите или зарегистрируйтесь");
            System.out.println("  1 Войти");
            System.out.println(" 2 Зарегистрироваться");
            System.out.println(" 0 Завершить работу");
            int loginChoose = scanner.nextInt();
            switch (loginChoose) {
                case 1: {
                    System.out.println("Введите логин");
                    String userName = scanner.next();
                    System.out.println("Введите пароль");
                    String password = scanner.next();
                }
                case 2: {
                    System.out.println("Введите логин");
                    String userName = scanner.next();
//                    boolean loginUnique = userService.checkLogin(userName);
//                    if (loginUnique) {
//                        System.out.println("Введитее пароль");
//                        String password = scanner.next();
//                        boolean passwordValid = userValidator.checkPassword(password);
//                        if (passwordValid) {
//
//                        } else {
//                            System.out.println("Пароль должен иметь не менее 8 символов," +
//                                    " и 2 буквы в своем составе, повторите ввод");
//                            break;
//                        }
//                    } else {
//                        System.out.println(" Логин должен быть уникальным повторите вволд");
//                        break;
//                    }
                }
                case 0:
                    return;
            }
        }
    }

}
