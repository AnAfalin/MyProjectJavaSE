package part3.task6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<String> listString = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("9.Stream/src/part3/task6/Applicants.txt"))){
            while (bufferedReader.ready()){
                listString.add(bufferedReader.readLine());
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
        System.out.println(listString);
    }
}
