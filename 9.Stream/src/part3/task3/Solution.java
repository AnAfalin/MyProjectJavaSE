package part3.task3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        String[] subjects = {
                "Java", "Math", "Geology", "Theoretical Mechanics", "English"
        };

        Student[] students = new Student[5];
        String[] names = {"Alex", "Mike", "Irina", "Bob", "Peter"};

        for (int i = 0; i < students.length; i++) {
            Map<String, Integer> marks = new HashMap<>();
            int nonMark = new Random().nextInt(0, 5);
            for (int j = 0; j < subjects.length; j++) {
                if (j != nonMark) {
                    marks.put(subjects[j], new Random().nextInt(3, 6));
                }
            }
            students[i] = new Student(names[i], marks);
        }

        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println();

        Map<String, Double> averageMarkSubject = Arrays.stream(students)
                .flatMap(student -> student.getMarks().entrySet().stream())
                .collect(Collectors.groupingBy(
                        entry -> entry.getKey(),
                        Collectors.summingDouble(value -> value.getValue().doubleValue())
                ))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        el -> el.getKey(),
                        el -> (el.getValue() / subjects.length)
                ));

        System.out.println(averageMarkSubject);

        Map<String, Double> averageMark= Arrays.stream(students)
                .flatMap(student -> student.getMarks().entrySet().stream())
                .collect(Collectors.groupingBy(
                        entry -> entry.getKey(),
                        Collectors.averagingDouble(value -> value.getValue().doubleValue())
                ));

        System.out.println(averageMark);
    }
}

