package part3.task4;

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

    public Person() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String[] getAnimals() {
        return animals;
    }

    public String getStringAnimals(){
        StringBuilder str = new StringBuilder();
        for (String el:animals) {
            str.append(el).append(", ");
        }
        str.delete(str.length() - 2 , str.length() - 1);
        return str.toString();
    }

    public void setAnimals(String[] animals) {
        this.animals = animals;
    }

    @Override
    public String toString() {
        return firstname + " " + lastname + ", " + age + ", " + job + ", " + Arrays.toString(animals);

    }
}
