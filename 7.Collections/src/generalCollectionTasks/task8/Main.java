package generalCollectionTasks.task8;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Site site = new Site();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter \"РЕГИСТРАЦИЯ\" or \"ВХОД\" or \"ВЫХОД\"");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("РЕГИСТРАЦИЯ")) {
                System.out.println("Enter your username");
                String login = scanner.nextLine();
                System.out.println("Enter the password");
                String password = scanner.nextLine();

                if (site.registration(login, password)) {
                    System.out.println("The user is registered");
                    break;
                } else {
                    System.out.println("A user with this username already exists. Registration failed.");
                    continue;
                }
            }

            if (choice.equalsIgnoreCase("ВХОД")) {
                System.out.println("Enter your username");
                String login = scanner.nextLine();
                System.out.println("Enter the password");

                while (true) {
                    String password = scanner.nextLine();
                    if(site.isAdmin(login, password)){
                        System.out.println("Выберите действие:\n" +
                                "1\tполучение всех пользователей;\n" +
                                "2\tполучение всех пользователей, у которых надежный пароль (от 2 до 10 символов, есть как буквы, так и цифры);\n" +
                                "3\tполучение всех пользователей, которые в качестве логина использовали e-mail.");
                        while (true){
                            String numberChoice = scanner.nextLine();
                            if(numberChoice.matches("[1-3]")){
                                site.functionAdmin(numberChoice);
                            }else {
                                System.out.println("Logged out of administrator mode.");
                                break;
                            }
                        }
                    }
                    if (site.enter(login, password) == 1) {
                        System.out.println("Log in on site");
                        break;
                    } else if (site.enter(login, password) == -1) {
                        System.out.println("The password is incorrect. Try again");
                    } else if (site.enter(login, password) == 0) {
                        System.out.println("User with login " + login + " is not registered.");
                        break;
                    }
                }
            }
        }
    }
}
