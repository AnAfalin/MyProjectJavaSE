package polymorphism.part1.task3;

public class Cat extends Animal {

    @Override
    public void info() {
        System.out.println("Кошка");
    }

    @Override
    public void say() {
        System.out.println("meow");
    }
}
