package part3.task3;

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Person[] people = new Person[3];
        people[0] = new Person("Christian", "Grey", 30, "Programmer", new String[]{"Cat", "Dog"});
        people[1] = new Person("Mike", "Scott", 20, "Manager", new String[]{"Cat"});
        people[2] = new Person("Ana", "Wilson", 22, "Programmer", new String[]{"Cat", "Dog", "Fish"});


        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("6.StreamInputOutput/src/part3/task3/CSV_data.csv"))) {

            for (Person el : people) {
                bufferedWriter.write(el.getFirstname() + "," + el.getLastname() + "," + el.getAge() + "," + el.getJob() + "," + Arrays.toString(el.getAnimals()));
                bufferedWriter.write("\n");
            }

            System.out.println("Исходные данные:");
            for (Person el : people) {
                System.out.println(el);
            }
            System.out.println();

        } catch (IOException e) {
            e.printStackTrace();
        }


        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("6.StreamInputOutput/src/part3/task3/CSV_data.csv"))) {
            Person[] people1 = new Person[3];
            String str;
            int i = 0;
            while ((str = bufferedReader.readLine()) != null) {
                String[] arrayStr = str.split(",");
                Person person = new Person();
                person.setFirstname(arrayStr[0]);
                person.setLastname(arrayStr[1]);
                person.setAge(Integer.parseInt(arrayStr[2]));
                person.setJob(arrayStr[3]);
                person.setAnimals(new String[arrayStr.length - 4]);
                for (int j = 4; j < arrayStr.length; j++) {
                    if (arrayStr[j].contains("[")) {
                        arrayStr[j] = arrayStr[j].substring(1);
                    }
                    if (arrayStr[j].contains("]")) {
                        arrayStr[j] = arrayStr[j].substring(0, (arrayStr[j]).length() - 1);
                    }
                    person.getAnimals()[j - 4] = arrayStr[j];
                }
                people1[i] = person;
                i++;
            }

            System.out.println("Полученные данные из файлы:");
            for (Person el : people1) {
                System.out.println(el);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
