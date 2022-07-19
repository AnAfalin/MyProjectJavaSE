package lesson.test3;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Test1 {
    public static void main(String[] args) throws Exception{
        Person p = new Person();
        Class<?> clazz = p.getClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor(String.class, int.class);

        Person person = (Person) constructor.newInstance("Peter", 20);

        Field name = clazz.getDeclaredField("name");
        Field age = clazz.getDeclaredField("age");

        name.setAccessible(true);
        age.setAccessible(true);

        System.out.println(name.get(person));
        System.out.println(age.get(person));

    }
}

class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }
}