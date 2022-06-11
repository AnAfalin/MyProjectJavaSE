package part3.task4;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    private static final String[] fieldFile = new String[]{"people", "person", "firstname", "lastname", "age", "job", "animals", "animal"};

    public void saveXMLFile(Person[] people, String path) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            bufferedWriter.write("<" + fieldFile[0] + ">\n");
            for (Person el : people) {
                bufferedWriter.write("<" + fieldFile[1] + ">\n");
                for (int i = 2; i < fieldFile.length - 1; i++) {
                    bufferedWriter.write("\t<" + fieldFile[i] + ">");
                    String valueField = el.getElementPerson(fieldFile[i]);
                    if(i == 6){
                        bufferedWriter.write("\n");
                        for (String animal:valueField.split(", ")) {
                            bufferedWriter.write("\t\t<" + fieldFile[7] + ">") ;
                            bufferedWriter.write(animal);
                            bufferedWriter.write("</" + fieldFile[7] + ">\n");
                        }
                        bufferedWriter.write("\t</" + fieldFile[i] + ">\n");
                    }else {
                        bufferedWriter.write(valueField);
                        bufferedWriter.write("</" + fieldFile[i] + ">\n");
                    }

                }
                bufferedWriter.write("</" + fieldFile[1] + ">\n");
            }
            bufferedWriter.write("</" + fieldFile[0] + ">\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Person[] downloadXMLFile(String path) {
        Person[] peopleRead = new Person[3];
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("6.StreamInputOutput/src/part3/task4/XML_data.xml"))) {
            List<String> fieldPerson = new ArrayList<>();
            String str;
            int k = 0;
            int countPerson = 0;
            while ((str = bufferedReader.readLine()) != null) {
                if (str.contains("/person")) {
                    String[] animals = new String[fieldPerson.size() - k - 4];
                    int j = 0;
                    for (int i = k + 4; i < fieldPerson.size(); i++, j++) {
                        animals[j] = fieldPerson.get(i);
                    }
                    Person person = new Person(fieldPerson.get(k), fieldPerson.get(k+1), Integer.parseInt(fieldPerson.get(k+2)), fieldPerson.get(k+3), animals);
                    peopleRead[countPerson] = person;
                    countPerson++;
                    k = fieldPerson.size();
                    continue;
                }
                if (!str.contains("people") && !str.contains("person") && !str.contains("animals")) {
                    str = str.substring(str.indexOf(">") + 1, str.lastIndexOf("<"));
                    fieldPerson.add(str);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return peopleRead;
    }
}
