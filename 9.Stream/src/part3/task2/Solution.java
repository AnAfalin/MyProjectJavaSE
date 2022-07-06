package part3.task2;

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
                }else {
                    marks.put(subjects[j], 0);
                }
            }
            students[i] = new Student(names[i], marks);
        }

        for (Student student : students) {
            System.out.println(student);
        }

        Arrays.stream(students)
                .collect(Collectors.toMap(
                                student -> student.getName(),
                                student -> student
                                        .getMarks()
                                        .entrySet()
                                        .stream()
                                        .map(entry -> entry.getValue())
                                        .mapToInt(mark -> mark.intValue())
                                        .average()
                                        .orElse(0.0)
                        )
                )
                .entrySet()
                .forEach(System.out::println);

    }
}

class Student {
    private String name;
    private Map<String, Integer> marks;

    public Student(String name, Map<String, Integer> marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public Map<String, Integer> getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return name + " " + marks;
    }
}

