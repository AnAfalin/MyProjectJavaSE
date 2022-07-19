package lesson.test1;

import java.lang.reflect.Field;
import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) throws Exception{
        Class<Person> clazz = Person.class;
        Arrays.stream(clazz.getDeclaredFields())
                .forEach(System.out::println);

        Person p = new Person();

        Field name = clazz.getDeclaredField("name");
        Field age = clazz.getDeclaredField("age");

        name.setAccessible(true);

        System.out.println(name.get(p));
        System.out.println(age.get(p));

        name.set(p, "Bob");
        age.set(p, 25);
        System.out.println(name.get(p));
        System.out.println(age.get(p));

    }
}

class Person{
    private String name = "Mike";
    public int age = 20;
}