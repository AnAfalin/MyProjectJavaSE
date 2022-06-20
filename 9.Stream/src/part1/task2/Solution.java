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

        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < 32; i++) {
            list1.add(i*i);
        }

        Stream<Integer> stream = list.stream().filter(list1::contains);
        stream.forEach(el-> System.out.print(el + " "));

    }
}
