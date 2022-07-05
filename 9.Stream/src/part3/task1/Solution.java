package part3.task1;

import java.util.*;
import java.util.stream.Collectors;

/*
•	Найти среднее каждого студента по предметам;
•	Получить String – название самого легкого предмета среди студентов.
•	Получить String – самого умного студента.
 */
public class Solution {

    public static void main(String[] args) {

        Student[] students = {
                new Student("Irina", Map.of("Java", new ArrayList<>(List.of(4.0, 3.0)), "Math", new ArrayList<>(List.of(4.0, 4.0, 5.0)))),
                new Student("Mike", Map.of("Java", new ArrayList<>(List.of(5.0, 3.0)), "Math", new ArrayList<>(List.of(3.0, 3.0)))),
                new Student("Peter", Map.of("Java", new ArrayList<>(List.of(5.0, 5.0, 5.0, 5.0)), "Math", new ArrayList<>(List.of(4.0, 5.0, 4.0)))),
                new Student("Fedor", Map.of("Java", new ArrayList<>(List.of(3.0)), "Math", new ArrayList<>(List.of(3.0))))
        };


//        Arrays.stream(students)
//                .collect(Collectors.toMap(
//                        student -> student.getName(),
//                        student -> student.getMarks()
//                                .entrySet()
//                                .stream()
//                                .collect(Collectors.toMap(
//                                        entry -> entry.
//                                ))
//                ))

        Map<String, Double> objectAverageMarks =
                Arrays.stream(students)
                        .map(Student::getMarks)
                        .flatMap(marks -> marks.entrySet().stream())
                        .collect(Collectors.groupingBy(
                                map -> map.getKey(),
                                Collectors.averagingDouble(map -> map.getValue()
                                        .stream()
                                        .mapToDouble(el -> el.doubleValue())
                                        .average()
                                        .orElse(0.0)
                                ))
                        );
        System.out.println("Средняя оценка по каждому предмету среди всех студентов\n" + objectAverageMarks);


        double averageMarkAllObject = Arrays.stream(students)
                .map(student -> student.getMarks())
                .flatMap(marks -> marks
                        .values()
                        .stream())
                .flatMap(list -> list.stream())
                .mapToDouble(mark -> mark.doubleValue())
                .average()
                .orElse(0.0);

        System.out.println("Общая средняя оценка всех студентов по всем студентам " + averageMarkAllObject);

        Map<String, String> listGeneralMarksStudent =
                Arrays.stream(students)
                        .collect(Collectors.toMap(
                                student -> student.getName(),
                                student -> student
                                        .getMarks()
                                        .values()
                                        .stream()
                                        .flatMap(marks -> marks.stream())
                                        .mapToDouble(el -> el.doubleValue())
                                        .sum()
                        ))
                        .entrySet()
                        .stream()
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                entry -> {
                                    if (entry.getValue() <= 7) {
                                        return "bad";
                                    } else if (entry.getValue() >= 8 && entry.getValue() <= 15) {
                                        return "normal";
                                    } else {
                                        return "good";
                                    }
                                }
                        ));

        System.out.println(listGeneralMarksStudent);



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