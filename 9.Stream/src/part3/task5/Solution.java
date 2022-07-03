package part3.task5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Student student1 = new Student("Alex", List.of(5, 4, 3, 5, 4));
        Student student2 = new Student("Mike", List.of(5, 4, 5, 5, 4));
        Student student3 = new Student("Jo", List.of(5, 5, 3, 5, 4));
        Student student4 = new Student("Liza", List.of(5, 3, 3, 5, 4));
        Student student5 = new Student("Peter", List.of(5, 4, 4, 5, 4));

        Student[] students = {student1, student2, student3, student4, student5};

        System.out.println("#1");
        Arrays.stream(students)
                .filter(student -> !student.getMarks().contains(3))
                .forEach(student -> System.out.println(student.getName()));

        System.out.println("\n#2");

        Arrays.stream(students)
                .forEach(student -> {
                    if(!student.getMarks().contains(3)){
                        System.out.println(student.getName());
                    }
                });

    }
}

class Student {
    private String name;
    private List<Integer> marks;

    public Student(String name, List<Integer> marks) {
        this.name = name;
        this.marks = marks;
    }

    public List<Integer> getMarks() {
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
