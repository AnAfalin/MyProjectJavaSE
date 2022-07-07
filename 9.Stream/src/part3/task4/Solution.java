package part3.task4;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {

        Map<String, List<Student>> mapGroup = new HashMap<>();

        mapGroup.put("Group #1", List.of(
                (new Student("Peter", List.of(4, 3, 5))),
                new Student("Mike", List.of(4, 3, 3))));
        mapGroup.put("Group #2", List.of(
                (new Student("Liza", List.of(3, 3, 3, 4))),
                new Student("Bob", List.of(4, 3, 5))));
        mapGroup.put("Group #3", List.of(
                (new Student("Irina", List.of(5, 5, 5))),
                new Student("Kate", List.of(4, 4))));

        String strongestGroup = mapGroup
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                entry -> entry.getValue()
                                        .stream()
                                        .map(Student::getMarks)
                                        .flatMap(Collection::stream)
                                        .mapToDouble(Integer::doubleValue)
                                        .average()
                                        .orElse(0.0)

                        )
                )
                .entrySet()
                .stream()
                .max((o1, o2) -> o1.getValue().compareTo(o2.getValue()))
                .map(Map.Entry::getKey)
                .orElse("Group #0");

        System.out.println("Самая сильная группа (группа с наибольшим средним баллом у студентов " + strongestGroup);

        mapGroup
                .values()
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toMap(
                        el -> el,
                        el -> el
                                .getMarks()
                                .stream()
                                .mapToDouble(Integer::doubleValue)
                                .average()
                                .orElse(0.0)
                ))
                .entrySet()
                .stream()
                .max((o1, o2) -> o1.getValue().compareTo(o2.getValue()))
                .map(Map.Entry::getKey)
                .ifPresent(student -> System.out.println("Самый сильный студент из всех групп " + student.getName()));


        double averageMarkAll = mapGroup
                .values()
                .stream()
                .flatMap(Collection::stream)
                .map(Student::getMarks)
                .map(marks -> marks
                        .stream()
                        .mapToDouble(Integer::doubleValue)
                        .average()
                        .orElse(0.0))
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);

        System.out.println("Средний балл студентов по группам " + averageMarkAll);


        List<String> listStudents = mapGroup
                .values()
                .stream()
                .flatMap(Collection::stream)
                .map(Student::getName)
                .collect(Collectors.toList());

        System.out.println("Список всех студентов: ");
        System.out.println(listStudents);


        List<Integer> listALlMarks = mapGroup
                .values()
                .stream()
                .flatMap(Collection::stream)
                .map(Student::getMarks)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        System.out.println("Список всех оценок студентов: ");
        System.out.println(listALlMarks);

        List<String> listHonorsStudent =
                mapGroup
                        .entrySet()
                        .stream()
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                entry -> entry
                                        .getValue()
                                        .stream()
                                        .map(Student::getMarks)
                                        .flatMap(Collection::stream)
                                        .collect(Collectors.toList())
                        ))
                        .entrySet()
                        .stream()
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                entry -> !entry.getValue().contains(3))
                        )
                        .entrySet()
                        .stream()
                        .filter(entry -> entry.getValue().equals(true))
                        .map(Map.Entry::getKey)
                        .toList();

        System.out.println("Список групп с отличниками " + listHonorsStudent);


        /*Сортировка по названию (по алфавиту), а если группа №22 есть?*/
        List<String> sortList = mapGroup
                .entrySet()
                .stream()
                .sorted((o1, o2) -> o2.getKey().compareTo(o1.getKey()))
                .map(Map.Entry::getKey)
                .toList();

        System.out.println("Список отсортированных по убыванию групп " + sortList);

    }
}


class Student {
    private String name;
    private List<Integer> marks;

    public Student(String name, List<Integer> marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return name + " " + marks.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(marks, student.marks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, marks);
    }
}