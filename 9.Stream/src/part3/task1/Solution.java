package part3.task1;

import java.util.*;

import java.util.stream.Collectors;


public class Solution {

    public static void main(String[] args) {
        Student student1 = new Student("Irina", Map.of("Java", new ArrayList<>(List.of(4.0, 4.0, 5.0)), "Math", new ArrayList<>(List.of(4.0, 4.0, 5.0))));
        Student student2 = new Student("Mike", Map.of("Java", new ArrayList<>(List.of(4.0, 3.0, 5.0)), "Math", new ArrayList<>(List.of(3.0, 3.0, 3.0))));
        Student student3 = new Student("Peter", Map.of("Java", new ArrayList<>(List.of(5.0, 5.0, 5.0)), "Math", new ArrayList<>(List.of(4.0, 5.0, 4.0))));

        Student[] students = {student1, student2, student3};

        //средняя оценка всех предметов каждого студента
        Map<String, Double> map = Arrays.stream(students)
                .collect(Collectors.toMap(
                        student -> student.getName(),
                        student -> student
                                .getMarks()
                                .values()
                                .stream()
                                .flatMap(list -> list.stream())
                                .mapToInt(el -> el.intValue())
                                .average()
                                .orElseThrow(() -> {
                                    throw new RuntimeException("no marks");
                                })
                ));

        System.out.println(map);


    }
}

class Student {
    private String name;
    private Map<String, List<Double>> marks;

    public Student(String name, Map<String, List<Double>> marks) {
        this.name = name;
        this.marks = marks;
    }

    public Map<String, List<Double>> getMarks() {
        return marks;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " " + marks;
    }
}