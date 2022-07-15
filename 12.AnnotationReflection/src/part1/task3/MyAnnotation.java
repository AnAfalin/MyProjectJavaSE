package part1.task3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})     //применяется только к полям и методам
@Retention(RetentionPolicy.RUNTIME)                 //видна во время выполнения программы
public @interface MyAnnotation {
        String author();
        int[] year();           //массив позволяет передавать несколько значений
        String description();
}


