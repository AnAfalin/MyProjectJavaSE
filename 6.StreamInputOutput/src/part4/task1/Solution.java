package part4.task1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");

        //запись в файл и чтение из файла с помощью потоков ввода-вывода
        String path1 = "6.StreamInputOutput/src/part4/task1/MapStream.txt";
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path1))){
            for (Map.Entry<Integer, String> entries:map.entrySet()) {
                String str = entries.getKey() + " - " + entries.getValue();
                bufferedWriter.write(str);
                bufferedWriter.write("\n");
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path1))){
            Map<Integer, String> mapReader = new HashMap<>();
            String str;
            while ((str = bufferedReader.readLine()) != null){
                int key = Integer.parseInt(str.substring(0, str.indexOf("-") - 1));
                String value = str.substring(str.indexOf("-") + 2);
                mapReader.put(key, value);
            }
            System.out.println(mapReader);
        }catch (IOException e){
            e.printStackTrace();
        }

        //запись в файл и чтение из файла с помощью класса Files
        List<String> list = new ArrayList<>();
        for (Map.Entry<Integer, String> entries:map.entrySet()) {
            list.add(entries.toString());
        }
        Files.write(Path.of("6.StreamInputOutput/src/part4/task1/MapFiles.txt"), list);

        List<String> listFiles = Files.readAllLines(Path.of("6.StreamInputOutput/src/part4/task1/MapFiles.txt"));
        System.out.println(listFiles);
    }
}
