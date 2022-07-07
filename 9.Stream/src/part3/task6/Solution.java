package part3.task6;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {

        /*поток только имен*/
        Path path = Path.of("9.Stream/src/part3/task6/Applicants.txt");
        try {
            Files.readAllLines(path)
                    .stream()
                    .map(list -> list.split(" "))
                    .map(string -> string[1])
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException();
        }

        /*поток имен и фамилий*/
        try {
            Files.readAllLines(path)
                    .stream()
                    .map(list -> list.substring(list.indexOf(" ") + 1, list.lastIndexOf(" ")))
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException();
        }

        /*поток студентов*/
        try {
            Files.readAllLines(path)
                    .stream()
                    .map(string -> string.split(" "))
                    .map(el -> new Student(
                            Integer.parseInt(el[0]),
                            el[1],
                            el[2],
                            Arrays.stream(el[3].substring(1, el[3].length() - 1).split(","))
                                    .map(s -> Integer.parseInt(s))
                                    .collect(Collectors.toList())))
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}

class Student {
    private int ID;
    private String name;
    private String surname;
    private List<Integer> marks;

    public Student(int ID, String name, String surname, List<Integer> marks) {
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return ID + " " + name + " " + surname + " " + marks;
    }
}
