package part3.task5.v2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.*;

public class Solution1 {
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

    public Student() {
        handleInjectValueFieldAnnotation();
    }

    private void handleInjectValueFieldAnnotation() {
        Arrays.stream(this.getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(InjectValueField.class))
                .forEach(field -> {
                    InjectValueField anno = field.getDeclaredAnnotation(InjectValueField.class);
                    Arrays.stream(anno.getClass().getDeclaredMethods())
                            .filter(annoMethod -> annoMethod.getName().equalsIgnoreCase(field.getName()))
                            .findFirst()
                            .ifPresent(method -> {
                                try {
                                    if (field.getType().isAssignableFrom(List.class)) {
                                        field.set(this, Arrays.stream((int[]) method.invoke(anno)).boxed().toList());
                                    } else {
                                        field.set(this, method.invoke(anno));
                                    }
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                            });
                });

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
