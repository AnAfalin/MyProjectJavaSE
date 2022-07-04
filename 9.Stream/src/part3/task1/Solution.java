package part3.task1;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Student student1 = new Student("Irina", Map.of("Java", new ArrayList<>(List.of(4.0, 3.0))/*, "Math", new ArrayList<>(List.of(4.0, 4.0, 5.0))*/));
        Student student2 = new Student("Mike", Map.of("Java", new ArrayList<>(List.of(5.0, 3.0))/*, "Math", new ArrayList<>(List.of(3.0, 3.0, 3.0))*/));
        Student student3 = new Student("Peter", Map.of("Java", new ArrayList<>(List.of(5.0, 5.0, 5.0, 5.0))/*, "Math", new ArrayList<>(List.of(4.0, 5.0, 4.0))*/));

        Student[] students = {student1, student2, student3};

        //средняя оценка всех предметов каждого студента
        Map<String, Double> map1 = Arrays.stream(students)
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

        System.out.println(map1);

        //средняя оценка по каждому предмету среди всех студентов
        Map<String, Double> map2 = Arrays.stream(students)
                .map(Student::getMarks)
                .flatMap(marks -> marks.entrySet().stream())
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.averagingDouble(el -> el.getValue()
                                .stream()
                                .mapToDouble(Double::doubleValue)
                                .average()
                                .getAsDouble()

                        )));

        System.out.println(map2);

        //средяя оценка среди всех студентов по всем предметам (общее среднее)
        double asDouble = Arrays.stream(students)
                .map(Student::getMarks)
                .flatMap(marks -> marks.values().stream())
                .flatMap(list -> list.stream())
                .mapToDouble(el -> el.doubleValue())
                .average()
                .getAsDouble();

        System.out.println(asDouble);

        Map<String, Optional<String>> map3 = Arrays.stream(students)
                .collect(Collectors.toMap(
                        student -> student.getName(),
                        student -> student.getMarks()
                                .values()
                                .stream()
                                .flatMap(list -> list.stream())
                                .reduce(Double::sum)
                                .map(el -> {
                                    if (el <= 7) {
                                        return "bad";
                                    } else if (el >= 8 && el <= 15) {
                                        return "normal";
                                    } else {
                                        return "good";
                                    }
                                })));
        System.out.println(map3);



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