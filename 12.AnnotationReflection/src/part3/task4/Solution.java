package part3.task4;

import java.lang.reflect.Constructor;

public class Solution {
    public static void main(String[] args) throws Exception {
        Class<Person> personClass = Person.class;
        Constructor<Person> constructorPerson1 = personClass.getConstructor(String.class, int.class);
        Constructor<Person> constructorPerson2 = personClass.getConstructor(String.class, int.class, String.class);
        Person person1 = constructorPerson1.newInstance("Peter", 45);
        Person person2 = constructorPerson2.newInstance("Mike", 25, "Doctor");

        System.out.println(person1);
        System.out.println(person2);
    }
}

class Person{
    private String name;
    private int age;
    private String profession;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, String profession) {
        this.name = name;
        this.age = age;
        this.profession = profession;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", profession='" + profession + '\'' +
                '}';
    }
}
