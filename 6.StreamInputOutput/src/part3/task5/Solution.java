package part3.task5;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private static final String[] fieldFile = new String[]{"people", "firstname", "lastname", "age", "job", "animals"};

    public void fillMap(Person[] people, List<Map<String, String>> list){
        for (Person el:people) {
            Map<String, String> map = new HashMap<>();
            map.put("firstname", el.getFirstname());
            map.put("lastname", el.getLastname());
            map.put("age", Integer.toString(el.getAge()));
            map.put("job", el.getJob());
            map.put("animals", el.getStringAnimals());
            list.add(map);
        }
    }

    public void saveJSONFile(List<Map<String, String>> list, String path) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            int countEl = 1;
            bufferedWriter.write("{\n");
            bufferedWriter.write("\"" + fieldFile[0] + "\":[\n");
            for (Map<String, String> el:list) {
                bufferedWriter.write("{\n");
                for (int i = 1; i < fieldFile.length; i++) {
                    bufferedWriter.write("\"" + fieldFile[i] + "\"");
                    if(i == fieldFile.length - 1){
                        bufferedWriter.write(":[");
                        String[] str = el.get(fieldFile[i]).split(", ");
                        for (int j = 0; j < str.length; j++) {
                            bufferedWriter.write("\"" + str[j] + "\"");
                            if(j != str.length - 1){
                                bufferedWriter.write(", ");
                            }
                        }
                        bufferedWriter.write("]");
                    }else {
                        bufferedWriter.write(":\"" + el.get(fieldFile[i]) + "\"");
                    }
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
    }

    public void downloadJSONFile(String path){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
            String str;
            List<Map<String, String>> list = new ArrayList<>();
            Map<String, String> map = null;

            while ((str = bufferedReader.readLine()) != null){
                if(str.contains("{")){
                    map = new HashMap<>();
                    continue;
                }
                if(str.equals("]")){
                    break;
                }
                if(str.contains("}")){
                    list.add(map);
                    continue;
                }
                for (int i = 1; i < fieldFile.length; i++) {
                    if(str.contains(fieldFile[i])){
                        int indexFirst = 0;
                        int indexSecond = str.indexOf("\"", indexFirst+1);
                        int indexThird = str.indexOf("\"", indexSecond + 1);
                        int indexFourth = str.indexOf("\"", indexThird + 1);
                        String key = str.substring(indexFirst + 1, indexSecond);
                        String value;
                        if(str.contains(fieldFile[5])){
                            value = str.substring(indexThird + 1, str.length() - 1).replace("\"", "");
                        }else {
                            value = str.substring(indexThird + 1, indexFourth);
                        }
                        map.put(key, value);
                    }
                }
            }

            Person[] people = new Person[list.size()];
            int i = 0;
            for (Map<String, String> el:list) {
                Person p = new Person();
                for (String key:el.keySet()) {
                    p.setValueField(key, el.get(key));
                }
                people[i] = p;
                i++;
            }

            System.out.println("Download array:");
            for (int j = 0; j < people.length; j++) {
                System.out.println(people[j]);
            }


        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
