package lesson.test4;

import java.lang.annotation.*;
import java.lang.reflect.Field;

public class AnnoMain {
    public static void main(String[] args) {
        Student s = new Student();
        System.out.println(s);
    }

}

class Student{

    @InjectRandomInt(number = 5)
    private int mark;

    public Student() {
        try {
            Field field = this.getClass().getDeclaredField("mark");

            if(field.isAnnotationPresent(InjectRandomInt.class)){
                InjectRandomInt anno = field.getDeclaredAnnotation(InjectRandomInt.class);
                int num = anno.number();
                field.set(this, num);
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public String toString() {
        return "Student{" +
                "mark=" + mark +
                '}';
    }
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface InjectRandomInt {
    int number();
}
