package part3.task4;

import java.io.*;
import java.util.Arrays;

public class Solution {
    private static final String[] fieldFile = new String[]{"people", "firstname", "lastname", "age", "job", "animals"};

    public static void main(String[] args) {
        Person[] people = new Person[3];
        people[0] = new Person("Christian", "Grey", 30, "Programmer", new String[]{"Cat", "Dog"});
        people[1] = new Person("Mike", "Scott", 20, "Manager", new String[]{"Cat"});
        people[2] = new Person("Ana", "Wilson", 22, "Programmer", new String[]{"Cat", "Dog", "Fish"});


        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("6.StreamInputOutput/src/part3/task4/XML_data.xml"))) {
            bufferedWriter.write("<root>\n");
            for (Person el : people) {
                bufferedWriter.write("<" + fieldFile[0] + ">\n");
                for (int i = 1; i < fieldFile.length; i++) {
                    bufferedWriter.write("\t<" + fieldFile[i] + ">");
                    bufferedWriter.write(el.getElementPerson(fieldFile[i]));
                    bufferedWriter.write("</" + fieldFile[i] + ">\n");
                }
                bufferedWriter.write("</" + fieldFile[0] + ">\n");
            }
            bufferedWriter.write("</root>");
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("6.StreamInputOutput/src/part3/task4/XML_data.xml"))) {
            Person[] peopleRead = new Person[3];
            String str;
            int i = 0;
            while ((str = bufferedReader.readLine()) != null) {

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
