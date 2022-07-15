package part1.task4;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})     //применяется только к полям и методам
@Retention(RetentionPolicy.RUNTIME)                 //видна во время выполнения программы
public @interface AnnotationDate {
        int value();
        int month() default 01;
        int day() default 01;
}



