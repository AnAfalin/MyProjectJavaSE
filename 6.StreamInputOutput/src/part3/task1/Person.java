package part3.task1;

import java.util.Arrays;

public class Person {
    private String firstname;
    private String lastname;
    private int age;
    private String job;
    private String[] animals;

    public Person(String firstname, String lastname, int age, String job, String[] animals) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.job = job;
        this.animals = animals;
    }

    @Override
    public String toString() {
        return firstname + " " + lastname + " " + age + " " + job + " " + Arrays.toString(animals);
    }
}
