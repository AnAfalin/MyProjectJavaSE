package part3.task4;

import java.io.*;
import java.util.Arrays;

public class Solution {
    private static final String[] fieldFile = new String[]{"people", "firstname", "lastname", "age", "job", "animals"};

    public void saveXMLFile(Person[] people, String path) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
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
    }

    public Person[] downloadXMLFile(String path) {
        Person[] peopleRead = new Person[3];
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("6.StreamInputOutput/src/part3/task4/XML_data.xml"))) {
            String[] fieldPerson = new String[5];
            String str;
            int i = 0;
            int countPerson = 0;
            while ((str = bufferedReader.readLine()) != null) {

                if (str.contains("/people")) {
                    Person person = new Person(fieldPerson[0], fieldPerson[1], Integer.parseInt(fieldPerson[2]), fieldPerson[3], (fieldPerson[4]).split(", "));
                    peopleRead[countPerson] = person;
                    countPerson++;
                    i = 0;
                    continue;
                }
                if (!str.contains("root") && !str.contains("people")) {
                    str = str.substring(str.indexOf(">") + 1, str.lastIndexOf("<"));
                    fieldPerson[i] = str;
                    i++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return peopleRead;
    }
}
