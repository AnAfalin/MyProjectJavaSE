package part3.task5.v1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws NoSuchMethodException {
        Student s = new Student();
        System.out.println(s);
    }
}

class Student {

    @InjectValueField(name = "Mike")
    private String name;

    @InjectValueField(age = 18)
    private int age;

    @InjectValueField(marks = {5, 5, 5})
    private List<Integer> marks;

    public Student()  {
        try {
            Field fieldName = this.getClass().getDeclaredField("name");
            if(fieldName.isAnnotationPresent(InjectValueField.class)){
                InjectValueField anno = fieldName.getDeclaredAnnotation(InjectValueField.class);
                String valueName = anno.name();
                fieldName.set(this, valueName);
            }
            Field fieldAge = this.getClass().getDeclaredField("age");
            if(fieldAge.isAnnotationPresent(InjectValueField.class)){
                InjectValueField anno = fieldAge.getDeclaredAnnotation(InjectValueField.class);
                int valueAge = anno.age();
                fieldAge.set(this, valueAge);
            }
            Field fieldMarks = this.getClass().getDeclaredField("marks");
            if(fieldMarks.isAnnotationPresent(InjectValueField.class)){
                InjectValueField anno = fieldMarks.getDeclaredAnnotation(InjectValueField.class);
                List<Integer> valueMarks = Arrays.stream(anno.marks())
                        .boxed()
                        .toList();
                fieldMarks.set(this, valueMarks);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", marks=" + marks +
                '}';
    }
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface InjectValueField {
    String name() default "Tom";
    int age() default 15;
    int[] marks() default {0};

}
