package part3.task4;

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Person[] people = new Person[3];
        people[0] = new Person("Christian", "Grey", 30, "Programmer", new String[]{"Cat", "Dog"});
        people[1] = new Person("Mike", "Scott", 20, "Manager", new String[]{"Cat"});
        people[2] = new Person("Ana", "Wilson", 22, "Programmer", new String[]{"Cat", "Dog", "Fish"});


        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("6.StreamInputOutput/src/part3/task4/XML_data.xml"))) {
        bufferedWriter.write("<root>\n");
            for (Person el:people) {
                bufferedWriter.write("<people>\n");
                bufferedWriter.write("\t<firstname>" + el.getFirstname() + "</firstname>\n");
                bufferedWriter.write("\t<lastname>" + el.getLastname() + "</lastname>\n");
                bufferedWriter.write("\t<age>" + el.getAge() + "</age>\n");
                bufferedWriter.write("\t<job>" + el.getJob() + "</job>\n");
                bufferedWriter.write("\t<animals>" + el.getStringAnimals() + "</animals>\n");
                bufferedWriter.write("</people>\n");
            }
            bufferedWriter.write("</root>");


        } catch (IOException e) {
            e.printStackTrace();
        }


//        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("6.StreamInputOutput/src/part3/task3/XML_data.xml"))) {
//
//

//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
