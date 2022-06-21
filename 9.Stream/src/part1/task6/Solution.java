package part1.task6;

import java.util.*;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        String nameFirstStudent = "Alex";
        Map<String, List<Integer>> marksFirstStudent = new HashMap<>();
        marksFirstStudent.put("Русский язык", new ArrayList<>(List.of(5, 5, 3, 5, 5)));
        marksFirstStudent.put("Математика", new ArrayList<>(List.of(5, 4, 4, 5, 5)));

        Student studentFirst = new Student(nameFirstStudent, marksFirstStudent);

        String nameSecondStudent = "Peter";
        Map<String, List<Integer>> marksSecondStudent = new HashMap<>();
        marksSecondStudent.put("Русский язык", new ArrayList<>(List.of(3, 3, 3, 4, 5)));
        marksSecondStudent.put("Математика", new ArrayList<>(List.of(5, 4, 4, 5, 5)));

        Student studentSecond = new Student(nameSecondStudent, marksSecondStudent);

        Student[] students = {studentFirst, studentSecond};

        Arrays.stream(students)
                .flatMap(el->el.getMarks().values().stream())
                .flatMap(el->el.stream())
                .forEach(System.out::println);

    }
}
