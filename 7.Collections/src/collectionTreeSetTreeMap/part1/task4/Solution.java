package collectionTreeSetTreeMap.part1.task4;

import java.util.Comparator;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {


        Comparator<Student> comparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.getAge() == o2.getAge()){
                    return o1.getName().compareTo(o2.getName());
                }
                return Integer.compare(o2.getAge(), o1.getAge());
            }
        };
        TreeSet<Student> students = new TreeSet<>(comparator);
        students.add(new Student("Светлана", 45));
        students.add(new Student("Алексей", 45));
        students.add(new Student("Алексей", 40));
        students.add(new Student("Александр", 40));
        students.add(new Student("Дмитрий", 20));
        System.out.println(students);
    }
}
