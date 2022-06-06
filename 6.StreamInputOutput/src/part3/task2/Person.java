package part3.task2;

import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;

public final class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = -4407115334700927133L;
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
        return firstname + " " + lastname + ", " + age + ", " + job + ", " + Arrays.toString(animals);
    }
}
