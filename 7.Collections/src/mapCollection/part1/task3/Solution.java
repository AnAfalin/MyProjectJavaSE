package mapCollection.part1.task3;

import java.util.*;

public class Solution {
    static Map<String, User> map = new HashMap<String, User>();

    static class User {
        String name;
        String login;
        String password;

        public User(String name, String login, String password) {
            this.name = name;
            this.login = login;
            this.password = password;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getPassword() {
            return password;
        }

        @Override
        public String toString() {
            return "User: {" +
                    "name='" + name + '\'' +
                    ", login='" + login + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }

    public static void info(String keyString) {
        if (keyString.equalsIgnoreCase("info")) {
            System.out.println("Общее количество пользователей в системе: " + map.size());
        } else if (keyString.equalsIgnoreCase("logins")) {
            Set<String> listOfLogins = map.keySet();
            for (String el : listOfLogins) {
                System.out.println(el);
            }
        } else if (keyString.equalsIgnoreCase("users")) {
            Set<Map.Entry<String, User>> listUsers = map.entrySet();
            for (Map.Entry<String, User> el : listUsers) {
                System.out.println(el);
            }
        } else {
            System.out.println("Введене неверный ключ доступа к информации");
        }
    }

    public static void main(String[] args) {

        map.put("afalin", new User("anastasia", "afalin", "sea5"));

        boolean isCorrect = false;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Вы хотите получить данные системы? yes/no");
            if (scanner.nextLine().equalsIgnoreCase("yes")) {
                System.out.println("Введите ключ доступа");
                info(scanner.nextLine());
            } else {
                System.out.println("Вы хотите войти в систему? yes/no");
                if (scanner.nextLine().equalsIgnoreCase("yes")) {
                    System.out.println("Введите логин");
                    String login = scanner.nextLine();

                    if (map.containsKey(login)) {
                        System.out.println("Введите пароль");
                        String password = scanner.nextLine();
                        if (map.get(login).getPassword().equals(password)) {
                            System.out.println("Доступ получен. " + map.get(login));
                            isCorrect = true;
                        }else {
                            System.out.println("Введен неверный пароль");
                        }

                    } else {
                        System.out.println("Введите информация для создания нового пользователя: имя, логин, пароль");
                        String input = scanner.nextLine();
                        String[] arrayInput = input.split(" ");
                        map.put(arrayInput[1], new User(arrayInput[0], arrayInput[1], arrayInput[2]));
                    }
                }
            }
        } while (!isCorrect);
    }
}
