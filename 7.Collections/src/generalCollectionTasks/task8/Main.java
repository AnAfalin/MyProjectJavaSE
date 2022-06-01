package generalCollectionTasks.task8;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Site site = new Site();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите \"РЕГИСТРАЦИЯ\" или \"ВХОД\" или \"ВЫХОД\"");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("РЕГИСТРАЦИЯ")) {
                System.out.println("Введите логин");
                String login = scanner.nextLine();
                System.out.println("Введите пароль");
                String password = scanner.nextLine();

                if (site.registration(login, password)) {
                    System.out.println("Пользователь зарегестрирован");
                    break;
                } else {
                    System.out.println("Пользователь с таким логином уже существует. Регистрация не выполнена.");
                    continue;
                }
            }

            if (choice.equalsIgnoreCase("ВХОД")) {
                System.out.println("Введите логин");
                String login = scanner.nextLine();
                System.out.println("Введите пароль");

                while (true) {
                    String password = scanner.nextLine();
                    if(site.isAdmin(login, password)){
                        System.out.println("Выберите действие:\n" +
                                "1\tполучение всех пользователей;\n" +
                                "2\tполучение всех пользователей, у которых надежный пароль (от 2 до 10 символов, есть как буквы, так и цифры);\n" +
                                "3\tполучение всех пользователей, которые в качестве логина использовали e-mail.");
                        while (true){
                            String numberChoice = scanner.nextLine();
                            if(numberChoice.matches("[1-3]+")){
                                site.functionAdmin(numberChoice);
                            }else {
                                System.out.println("Logged out of administrator mode.");
                                break;
                            }
                        }
                    }
                    if (site.enter(login, password) == 1) {
                        System.out.println("Выполнен вход на сайт");
                        break;
                    } else if (site.enter(login, password) == -1) {
                        System.out.println("Пароль неправильный. Повторите попытку");
                    } else if (site.enter(login, password) == 0) {
                        System.out.println("Пользователь с логином " + login + " не зарегестрирован.");
                        break;
                    }
                }
            }

        }
    }
}
