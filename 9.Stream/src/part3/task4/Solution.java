package part3.task4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
                                entry -> entry.getKey(),
                                entry -> entry.getValue()
                                        .stream()
                                        .map(student -> student.getMarks())
                                        .flatMap(list -> list.stream())
                                        .mapToDouble(mark -> mark.doubleValue())
                                        .average()
                                        .orElse(0.0)

                        )
                )
                .entrySet()
                .stream()
                .max((o1, o2) -> o1.getValue().compareTo(o2.getValue()))
                .map(el -> el.getKey())
                .orElse("Group #0");

        System.out.println("Самая сильная группа (группа с наибольшим средним баллом у студентов " + strongestGroup);

        /*Если студенты повторяются?*/
        String bestStudent = mapGroup
                .values()
                .stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.toMap(
                        student -> student.getName(),
                        student -> student
                                .getMarks()
                                .stream()
                                .mapToDouble(el -> el.doubleValue())
                                .average()
                                .orElse(0.0)
                ))
                .entrySet()
                .stream()
                .max((o1, o2) -> o1.getValue().compareTo(o2.getValue()))
                .map(el -> el.getKey())
                .orElse("Nobody");


        System.out.println("Самый сильный студент из всех групп " + bestStudent);


        double averageMarkAll = mapGroup
                .values()
                .stream()
                .flatMap(list -> list.stream())
                .map(student -> student.getMarks())
                .map(marks -> marks
                        .stream()
                        .mapToDouble(mark -> mark.doubleValue())
                        .average()
                        .orElse(0.0))
                .mapToDouble(averageMark -> averageMark.doubleValue())
                .average()
                .orElse(0.0);

        System.out.println("Средний балл студентов по группам " + averageMarkAll);


        List<String> listStudents = mapGroup
                .entrySet()
                .stream()
                .map(group -> group.getValue())
                .flatMap(list -> list.stream())
                .map(student -> student.getName())
                .collect(Collectors.toList());

        System.out.println("Список всех студентов: ");
        System.out.println(listStudents);


        List<Integer> listALlMarks = mapGroup
                .values()
                .stream()
                .flatMap(Collection::stream)
                .map(student -> student.getMarks())
                .flatMap(listMarks -> listMarks.stream())
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
                                        .map(student -> student.getMarks())
                                        .flatMap(marks -> marks.stream())
                                        .collect(Collectors.toList())
                        ))
                        .entrySet()
                        .stream()
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                entry -> {
                                    if (entry.getValue().contains(3)) {
                                        return false;
                                    } else {
                                        return true;
                                    }
                                })
                        )
                        .entrySet()
                        .stream()
                        .filter(entry -> entry.getValue().equals(true))
                        .map(group -> group.getKey())
                        .collect(Collectors.toList());

        System.out.println("Список групп с отличниками " + listHonorsStudent);


        /*Сортировка по названию (по алфавиту), а если группа №22 есть?*/
        List<String> sortList = mapGroup
                .entrySet()
                .stream()
                .sorted((o1, o2) -> o2.getKey().compareTo(o1.getKey()))
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());

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
}