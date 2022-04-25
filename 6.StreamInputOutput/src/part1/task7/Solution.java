package part1.task7;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("6.StreamInputOutput/src/part1/task7/Students")))
        {
            List<String> list = new ArrayList<>();
            String str = null;
            int i = 0;
                while((str = bufferedReader.readLine()) != null){
                    list.add(i, str);
                    i++;
                }
                String[] arrayOfStudents = new String[list.size()];
            for (int j = 0; j < arrayOfStudents.length; j++) {
                arrayOfStudents[j] = list.get(j);
            }
            for (String el:arrayOfStudents) {
                System.out.println(el);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
