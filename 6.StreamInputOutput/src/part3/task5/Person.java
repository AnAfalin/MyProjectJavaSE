package part3.task5;

import java.util.Arrays;

public final class Person {
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

    public String getElementPerson(String string){
        return switch (string) {
            case "firstname" -> firstname;
            case "lastname" -> lastname;
            case "age" -> Integer.toString(age);
            case "job" -> job;
            case "animals" -> getStringAnimals();
            default -> "";
        };
    }

    public String getStringAnimals(){
        StringBuilder str = new StringBuilder();
        for (String el:animals) {
            str.append(el).append(", ");
        }
        str.delete(str.length() - 2 , str.length());
        return str.toString();
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    public String getJob() {
        return job;
    }

    public String[] getAnimals() {
        return animals;
    }

    @Override
    public String toString() {
        return firstname + " " + lastname + ", " + age + ", " + job + ", " + Arrays.toString(animals);

    }
}
