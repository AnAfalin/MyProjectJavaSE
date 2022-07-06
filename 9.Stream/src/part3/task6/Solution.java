package part3.task6;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    public static void main(String[] args) {
        List<String> listString = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("9.Stream/src/part3/task6/Applicants.txt"))){
            while (bufferedReader.ready()){
                listString.add(bufferedReader.readLine());
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
        System.out.println(listString);


        /*поток только имен*/
        Stream<String> nameStream = listString
                .stream()
                .map(list -> list.split(" "))
                .map(string -> string[1]);

        nameStream.forEach(System.out::println);


        /*поток имен и фамилий*/
        Stream<String> nameSurnameStream = listString
                .stream()
                .map(list -> list.substring(list.indexOf(" ") + 1, list.lastIndexOf(" ")));

        nameSurnameStream.forEach(System.out::println);


        /*поток студентов*/
        Stream<Student> studentStream = listString
                .stream()
                .map(string -> string.split(" "))
                .map(el -> new Student(
                        Integer.parseInt(el[0]),
                        el[1],
                        el[2],

                        Arrays.stream(el[3].substring(1, el[3].length() - 1).split(","))
                                .map(s -> Integer.parseInt(s))
                                .collect(Collectors.toList())));

        studentStream.forEach(System.out::println);

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
