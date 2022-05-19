package collectionTreeSetTreeMap.part1.task3;

import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        TreeSet<Student> students = new TreeSet<>();
        students.add(new Student("Светлана", 45));
        students.add(new Student("Алексей", 45));
        students.add(new Student("Алексей", 40));
        students.add(new Student("Александр", 40));
        students.add(new Student("Дмитрий", 20));
        System.out.println(students);
    }
}
