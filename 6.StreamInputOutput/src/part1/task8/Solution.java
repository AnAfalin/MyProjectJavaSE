package part1.task8;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("6.StreamInputOutput/src/part1/task8/Words"));
        BufferedWriter bufferedWriter1 = new BufferedWriter(new FileWriter("6.StreamInputOutput/src/part1/task8/first.txt"));
        BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter("6.StreamInputOutput/src/part1/task8/second.txt"));
        BufferedWriter bufferedWriter3 = new BufferedWriter(new FileWriter("6.StreamInputOutput/src/part1/task8/third.txt")))
        {
            List<String> list = new ArrayList<>();
            String str;
            int i = 0;
                while((str = bufferedReader.readLine()) != null){
                    list.add(i, str);
                    i++;
                }
                String string;
            for (int j = 0; j < list.size(); j++) {
                string = list.get(j);
                if(string.matches("\\b[A-ZА-Я][a-zа-я]*")){
                    bufferedWriter1.write(string);
                }
                if(string.matches("\\b[A-Za-zА-Яа-я]{5}\\b")){
                    bufferedWriter2.write(string);
                }
                if(string.matches("\\b[^0-9A-ZА-Я\\s]+\\b")){
                    bufferedWriter3.write(string);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
