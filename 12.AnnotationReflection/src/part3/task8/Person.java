package part3.task8;

import java.time.LocalDate;

public class Person {
    private String name;
    private int age;
    private Animal animal;

    public Person() {
    }

    public Person(String name, int age, Animal animal) {
        this.name = name;
        this.age = age;
        this.animal = animal;
    }
}
