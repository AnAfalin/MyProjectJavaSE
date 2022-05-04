package part2.task4;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Student student = new Student("Сергей", "Иванов", new ArrayList<>(Arrays.asList(4.0, 5.0, 3.0)));
        Student student2 = new Student("Елена", "Светлая", new ArrayList<>(Arrays.asList(4.0, 3.0, 3.5)));
        Student student3 = new Student("Дмитрий", "Польских", new ArrayList<>(Arrays.asList(4.5, 5.0, 4.0)));

        Student[] arrStudent = new Student[3];
        arrStudent[0] = student;
        arrStudent[1] = student2;
        arrStudent[2] = student3;

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("6.StreamInputOutput/src/part2/task4/Students.bin"))){
            oos.writeObject(arrStudent);
        }  catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("6.StreamInputOutput/src/part2/task4/Students.bin"))){
            Student[] arrInput = (Student[]) ois.readObject();
            for (int i = 0; i < arrInput.length; i++) {
                System.out.println(arrInput[i]);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
