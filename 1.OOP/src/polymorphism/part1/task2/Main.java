package polymorphism.part1.task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Human human;
        Animal animal = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите животное, которое Вы хотите создать: \"Dog\", \"Cat\", \"Fish\"");
        String enterAnimal = scanner.nextLine();
        if (enterAnimal.equalsIgnoreCase("Dog")) {
            animal = new Dog();
        }else if (enterAnimal.equalsIgnoreCase("Fish")) {
            animal = new Fish();
        } else if (enterAnimal.equalsIgnoreCase("Cat")) {
            animal = new Cat();
        }

        System.out.println("Введите Ваше имя");
        String name = scanner.nextLine();
        System.out.println("Введите Ваш возраст");
        int age = scanner.nextInt();
        human = new Human(name, age, animal);
        human.getAnimal();
    }
}
