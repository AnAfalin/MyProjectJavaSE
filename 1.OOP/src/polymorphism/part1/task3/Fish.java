package polymorphism.part1.task3;

public class Fish extends Animal {

    @Override
    public void info() {
        System.out.println("Рыбка");
    }

    @Override
    public void say() {
        System.out.println("...");
    }
}
