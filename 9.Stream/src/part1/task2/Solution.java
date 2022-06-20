package part1.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1_000; i++) {
            list.add(i);
        }

        Stream<Integer> stream = list.stream().filter(el -> el == 0 || (Math.sqrt(el) / (int) Math.sqrt(el) == 1.0));
        stream.forEach(el -> System.out.print(el + " "));

    }
}
