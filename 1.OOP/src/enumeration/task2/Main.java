package enumeration.task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Human human;

        System.out.println("Введите Ваше ФИО");
        String name = scanner.nextLine();
        System.out.println("Введите Ваш возраст");
        int age = scanner.nextInt();

        System.out.println("Введите Ваш пол: \"male\" или \"female\"");
        while (true) {
            String gender = scanner.nextLine();
            if (gender.equalsIgnoreCase("Male")) {
                human = new Human(name, age, Gender.MALE);
                break;
            } else if (gender.equalsIgnoreCase("Female")) {
                human = new Human(name, age, Gender.FEMALE);
                break;
            } else {
                System.out.println("Вы ввели неккоректный пол. Повторите ввод");
            }
        }
        System.out.println(human);
    }
}
