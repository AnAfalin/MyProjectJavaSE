package lesson.test6;

import java.util.List;

public class TestUtils {
    public static void main(String[] args) throws Exception {
        List<Person> people = Utils.readAllLines("12.AnnotationReflection/src/lesson/test6/file.txt", Person.class);
        System.out.println(people);
    }
}
