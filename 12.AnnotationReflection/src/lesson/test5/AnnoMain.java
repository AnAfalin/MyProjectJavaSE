package lesson.test5;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.Random;

public class AnnoMain {
    public static void main(String[] args) {
        Student s = new Student();
        System.out.println(s);
    }

}

class Student{

    @InjectRandomInt
    private int mark;

    public Student() {
        try {
            Field field = this.getClass().getDeclaredField("mark");

            if(field.isAnnotationPresent(InjectRandomInt.class)){
                int num = new Random().nextInt(5)+1;
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
}
