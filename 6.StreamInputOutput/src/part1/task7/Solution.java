package part1.task7;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Solution {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("6.StreamInputOutput/src/part1/task7/Students")))
        {
            List<String> list = new ArrayList<>();
            String str;
            while ((str = bufferedReader.readLine()) != null)
            list.add(str);

            List<Students> listOfStudents = new ArrayList<>();

                for (String value : list) {
                    String[] arr = value.split(" ");
                    listOfStudents.add(new Students(arr[0], arr[1], ((arr[2]).charAt((arr[2]).length() - 1)), Double.parseDouble(arr[3])));
                }

            Students[] arrayOfStudents = new Students[listOfStudents.size()];
            for (int i = 0; i < arrayOfStudents.length; i++) {
                arrayOfStudents[i] = listOfStudents.get(i);
            }
            for (int i = 0; i < arrayOfStudents.length; i++) {
                System.out.println(arrayOfStudents[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
