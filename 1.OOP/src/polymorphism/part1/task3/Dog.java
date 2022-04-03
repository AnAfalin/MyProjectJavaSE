package polymorphism.part1.task3;

public class Dog extends Animal {

    @Override
    public void info() {
        System.out.println("Собака");
    }

    @Override
    public void say() {
        System.out.println("woof");
    }
}
