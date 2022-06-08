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
        str.delete(str.length() - 2 , str.length());
        return str.toString();
    }

    public void setAnimals(String[] animals) {
        this.animals = animals;
    }

    public void setValueField(String key, String value){
        if(key.equalsIgnoreCase("firstname")){
            setFirstname(value);
        }
        if(key.equalsIgnoreCase("lastname")){
            setLastname(value);
        }
        if(key.equalsIgnoreCase("age")){
            setAge(Integer.parseInt(value));
        }
        if(key.equalsIgnoreCase("job")){
            setJob(value);
        }
        if(key.equalsIgnoreCase("animals")){
            setAnimals(value.split(", "));
        }
    }

    @Override
    public String toString() {
        return firstname + " " + lastname + ", " + age + ", " + job + ", " + Arrays.toString(animals);

    }
}
