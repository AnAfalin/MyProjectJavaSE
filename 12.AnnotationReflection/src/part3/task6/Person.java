package part3.task6;

import java.time.LocalDate;

public class Person {
    private String name;
    private int age;
    private LocalDate birthday;

    public Person() {
    }

    public Person(String name, int age, LocalDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Person [" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ']';
    }
}
