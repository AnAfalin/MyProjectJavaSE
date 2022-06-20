package part1.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        IntStream.rangeClosed(0, 1_000)
                        .forEach(list::add);

        list
                .stream()
                .filter(el -> el == 0 || (Math.sqrt(el) / (int) Math.sqrt(el) == 1.0))
                .forEach(el -> System.out.print(el + " "));

    }
}
