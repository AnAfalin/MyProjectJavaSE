package part1.task10;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            list.add(i);
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("6.StreamInputOutput/src/part1/task10/list.txt"))){
            Collections.reverse(list);
            for (int el:list) {
                bufferedWriter.write(el + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
