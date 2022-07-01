package lessons;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExampleFirst {
    public static void main(String[] args) {
        var marks1 = Map.of(
                "English", List.of(4, 4, 5),
                "Math", List.of(4, 4, 3),
                "Java", List.of(5, 4, 5));

        var marks2 = Map.of(
                "English", List.of(4, 5, 5),
                "Math", List.of(4, 3, 3),
                "Java", List.of(3, 4, 4));

        Student[] students = {
                new Student("Mike", marks1),
                new Student("Bob", marks2)};

        //Студент - средняя оценка по всем предметам
        Map<String, Double> map = Arrays.stream(students)
                .collect(Collectors.toMap(
                        student -> student.getName(),
                        student -> student
                                .getMarks()                               //Map<String, List<Integer>> marks
                                .values()                                 //List<Integer>
                                .stream()
                                .flatMap(Collection::stream)
                                .mapToInt(Integer::intValue)
                                .average()
                                .orElseGet(() -> {
                                    throw new RuntimeException("no marks");
                                })

                ));

        //Предмет - средняя оценка по всем студентам
        Map<String, Double> map2 =
                Arrays.stream(students)
                        .map(student -> student.getMarks())
                        .flatMap(marks -> marks.entrySet().stream())
                        .collect(Collectors.groupingBy(
                                Map.Entry::getKey,
                                Collectors.averagingDouble(entry -> entry
                                        .getValue()
                                        .stream()
                                        .mapToInt(intEl -> intEl.intValue())
                                        .average()
                                        .getAsDouble())
                        ));

        System.out.println(map);
        System.out.println(map2);
    }
}

class Student {
    private String name;
    private Map<String, List<Integer>> marks;

    public Student(String name, Map<String, List<Integer>> marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public Map<String, List<Integer>> getMarks() {
        return marks;
    }
}
