package lesson.test2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) throws Exception{
        Class<Person> clazz = Person.class;

        Constructor<Person> constructor = clazz.getDeclaredConstructor(String.class, int.class);

        Person p = constructor.newInstance("Peter", 20);

        Field name = clazz.getDeclaredField("name");
        Field age = clazz.getDeclaredField("age");

        name.setAccessible(true);
        age.setAccessible(true);

        System.out.println(name.get(p));
        System.out.println(age.get(p));

    }
}

class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}