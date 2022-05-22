package hashSetCollection.part1.task1;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Student student1 = new Student("Сергей", 18);
        student1.addMark(5,5);

        Student student2 = new Student("Илья", 19);
        student2.addMark(4, 3.5, 4);

        Student student3 = new Student("Ирина", 22);
        student3.addMark(4.5);

        Set<Student> hashSet = new HashSet<>();
        hashSet.add(student1);
        hashSet.add(student2);
        hashSet.add(student3);

        for (Student student:hashSet) {
            System.out.println(student);
        }

        Student student4 = new Student("Ирина", 22);
        Student student5 = new Student("Ирина", 22);

        hashSet.add(student4);
        hashSet.add(student5);

        //без переопределения методов "equals", "hashcode" в классе Students
        //Student Ирина, age 22, marks:
        //Student Ирина, age 22, marks:
        //Student Илья, age 19, marks: 4.0 3.5 4.0
        //Student Ирина, age 22, marks: 4.5
        //Student Сергей, age 18, marks: 5.0 5.0

        //после переопределение методов "equals", "hashcode" в классе Students
        //Student Ирина, age 22, marks: 4.5
        //Student Илья, age 19, marks: 4.0 3.5 4.0
        //Student Сергей, age 18, marks: 5.0 5.0
        //Student Ирина, age 22, marks:

        for (Student student:hashSet) {
            System.out.println(student);
        }
    }
}
