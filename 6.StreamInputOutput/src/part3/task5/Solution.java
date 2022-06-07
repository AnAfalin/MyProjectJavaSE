package part3.task5;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private static final String[] fieldFile = new String[]{"people", "firstname", "lastname", "age", "job", "animals"};

    public static void main(String[] args) {
        Person[] people = new Person[3];
        people[0] = new Person("Christian", "Grey", 30, "Programmer", new String[]{"Cat", "Dog"});
        people[1] = new Person("Mike", "Scott", 20, "Manager", new String[]{"Cat"});
        people[2] = new Person("Ana", "Wilson", 22, "Programmer", new String[]{"Cat", "Dog", "Fish"});

        List<Map<String, String>> list = new ArrayList<>();
        for (Person el:people) {
            Map<String, String> map = new HashMap<>();
            map.put("firstname", el.getFirstname());
            map.put("lastname", el.getLastname());
            map.put("age", Integer.toString(el.getAge()));
            map.put("job", el.getJob());
            map.put("animals", el.getStringAnimals());
            list.add(map);
        }


        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("6.StreamInputOutput/src/part3/task5/JSON_data.json"))) {
            int countEl = 1;
            bufferedWriter.write("{\n");
            bufferedWriter.write("\"" + fieldFile[0] + "\":[\n");
            for (Map<String, String> el:list) {
                bufferedWriter.write("{\n");
                for (int i = 1; i < fieldFile.length; i++) {
                    bufferedWriter.write("\"" + fieldFile[i] + "\"" + ":\"" + el.get(fieldFile[i]) + "\"");
                    if(i != fieldFile.length - 1){
                        bufferedWriter.write(",\n");
                    }
                }
                bufferedWriter.write("\n}");
                if(countEl != list.size()){
                    bufferedWriter.write(",");
                }
                bufferedWriter.write("\n");
                countEl++;
            }
            bufferedWriter.write("]\n}");

        } catch (IOException e) {
            e.printStackTrace();
        }
//
    }


}
