package part1.task4;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})     //применяется только к полям и методам
@Retention(RetentionPolicy.RUNTIME)                 //видна во время выполнения программы
public @interface AnnotationDate {

        //@AliasFor("year")     //аннотaция, указывающая что value относится к year, что это одно и тоже
        int value() default 1;
        int year() default 2022;
        int month() default 1;
        int day() default 1;
}



