package hashSetCollection.part1.task1;

import java.util.Arrays;
import java.util.Objects;

public class Student {
    private String name;
    private int age;
    private double[] marks;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        marks = new double[10];
    }

    public void addMark(double ... arr) {
        int index = indexEmptyCeil();
        if(index == -1){
            expandArrayMarks();
        }else if(index + arr.length >= marks.length){
            expandArrayMarks();
        }

        for (double el : arr) {
            putOnMarks(el);
        }
    }

    private void putOnMarks(double mark){
        int index = indexEmptyCeil();
        marks[index] = mark;
    }

    private int indexEmptyCeil(){
        for (int i = 0; i < marks.length; i++) {
            if(marks[i] == 0){
                return i;
            }
        }
        return -1;
    }

    private void expandArrayMarks(){
        double[] newMark = new double[marks.length * 2];
        System.arraycopy(marks, 0, newMark, 0, marks.length);
        marks = newMark;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("Student ").append(name).append(", age ").append(age).append(", marks: ");
        for (double mark : marks) {
            if (mark != 0) {
                string.append(mark).append(" ");
            }
        }
        return string.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name) && Arrays.equals(marks, student.marks);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, age);
        result = 31 * result + Arrays.hashCode(marks);
        return result;
    }
}
