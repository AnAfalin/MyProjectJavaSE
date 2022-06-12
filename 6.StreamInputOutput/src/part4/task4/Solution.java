package part4.task4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        List<String> list = new ArrayList<>();
        for (int el : array) {
            list.add(Integer.toString(el));
        }

        Files.write(Path.of("6.StreamInputOutput/src/part4/task4/file.txt"), list);

        List<String> loadList = Files.readAllLines(Path.of("6.StreamInputOutput/src/part4/task4/file.txt"));
        int[] loadArray = new int[loadList.size()];
        int i = 0;
        for (String s:loadList) {
            loadArray[i] = Integer.parseInt(s);
            i++;
        }
        Arrays.sort(loadArray);
        System.out.println(Arrays.toString(loadArray));

    }
}
