package part3.task1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Person[] array = new Person[3];
        array[0] = new Person("Christian", "Grey", 30, "PROGRAMMER", new String[]{"CAT", "DOG"});
        array[1] = new Person("Mike", "Scott", 20, "MANAGER", new String[]{"CAT"});
        array[2] = new Person("Ana", "Wilson", 22, "ANALYST", new String[]{"CAT", "FISH", "DOG"});

        System.out.println("Array for save in files:");
        for (Person el : array) {
            System.out.println(el);
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("6.StreamInputOutput/src/part3/task1/DataArray.txt"))) {
            int n = 1;
            for (Person el : array) {
                bufferedWriter.write(n + ". ");
                bufferedWriter.write(el.toString());
                bufferedWriter.write("\n");
                n++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\nReading a file with saved data...");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("6.StreamInputOutput/src/part3/task1/DataArray.txt"))) {
            List<String> list = new ArrayList<>();
            String readString;
            while ((readString = bufferedReader.readLine()) != null) {
                list.add(readString);
            }
            Person[] people = new Person[list.size()];
            int i = 0;
            String[] arr = list.get(0).split(" ");
            for (String str : list) {
                String[] arrStr = str.split(" ", 6);
                String firstname = arrStr[1];
                String lastname = arrStr[2];
                int age = Integer.parseInt(arrStr[3]);
                String job = arrStr[4];
                String[] animals = arrStr[5].substring(1, arrStr[5].length() - 1).split(", ");
                Person p = new Person(firstname, lastname, age, job, animals);
                people[i] = p;
                i++;
            }
            for (Person el:people) {
                System.out.println(el);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
