package polymorphism.part1.task2;

public class Human {
    private String name;
    private int age;
    private Animal animal;

    public Human(String name, int age, Animal animal) {
        this.name = name;
        this.age = age;
        this.animal = animal;
    }

    public void getAnimal() {
        animal.say();
    }
}
