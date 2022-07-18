package part3.task1;

import java.lang.reflect.Field;

public class Solution {
    public static <T> void setValueFieldObject(T object, Object...args) throws Exception {
        Class<?> aClass = object.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();

        for (int i = 0; i < declaredFields.length; i++) {
            declaredFields[i].setAccessible(true);
            declaredFields[i].set(object, args[i]);
        }

    }

    public static void main(String[] args) throws Exception {
        Person person = new Person();
        setValueFieldObject(person, "Peter", 40, "Doctor");
        System.out.println(person);
    }
}



class Person{
    private String name;
    private int age;
    private String profession;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", profession='" + profession + '\'' +
                '}';
    }
}