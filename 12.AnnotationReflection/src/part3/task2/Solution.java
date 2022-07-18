package part3.task2;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Doctor doctor = new Doctor();
        Class<?> aClass = doctor.getClass();

        List<Field[]> list = new ArrayList<>();
        while (aClass.getSuperclass() != null){
            list.add(aClass.getDeclaredFields());
            aClass = aClass.getSuperclass();
        }
        list.stream()
                .map(array -> Arrays.stream(array).toList())
                .flatMap(Collection::stream)
                .forEach(field -> System.out.println(field.getName()));
    }
}

class Person{
    private int age;
}

class Employee extends Person{
    private String experience;
}

class Doctor extends Employee{
    private String specialization;
}