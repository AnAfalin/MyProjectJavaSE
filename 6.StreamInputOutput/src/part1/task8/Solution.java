package part1.task8;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader("6.StreamInputOutput/src/part1/task8/Words"));
                BufferedWriter bufferedWriter1 = new BufferedWriter(new FileWriter("6.StreamInputOutput/src/part1/task8/first.txt"));
                BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter("6.StreamInputOutput/src/part1/task8/second.txt"));
                BufferedWriter bufferedWriter3 = new BufferedWriter(new FileWriter("6.StreamInputOutput/src/part1/task8/third.txt"))
        ) {
            List<String> list = new ArrayList<>();

            String str;

            while ((str = bufferedReader.readLine()) != null) {
                list.add(str);
            }

            for (int j = 0; j < list.size(); j++) {

                String[] words = list.get(j).split(" ");
                for (String word : words) {

                    word = word.replaceAll("[.,:;-]", "");

                    if (word.matches("[A-ZА-Я][a-zа-я]*")) {
                        bufferedWriter1.write(word + "\n");
                    }
                    if (word.matches("[A-Za-zА-Яа-я]{5}")) {
                        bufferedWriter2.write(word + "\n");
                    }
                    if (word.matches("[^0-9A-ZА-Я\\s]+")) {
                        bufferedWriter3.write(word + "\n");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
