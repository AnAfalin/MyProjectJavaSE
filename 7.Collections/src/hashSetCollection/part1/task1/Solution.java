package hashSetCollection.part1.task1;

import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        Student student1 = new Student("Сергей", 18);
        student1.addMark(5,5);

        Student student2 = new Student("Илья", 19);
        student2.addMark(4, 3.5, 4);

        Student student3 = new Student("Ирина", 22);
        student3.addMark(4.5);

        HashSet<Student> hashSet = new HashSet<>();
        hashSet.add(student1);
        hashSet.add(student2);
        hashSet.add(student3);
        for (Student student:hashSet) {
            System.out.println(student);
        }

        System.out.println("-------");

        Student student4 = new Student("Ирина", 22);
        student4.addMark(4.5); //добавиться, т.к. новый объект
        student3.addMark(4.5); //не добавится, т.к. объект такой уже есть

        hashSet.add(student4);
        for (Student student:hashSet) {
            System.out.println(student);
        }
    }
}
