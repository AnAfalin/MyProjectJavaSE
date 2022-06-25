package part2.task5;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new Random().nextInt(1, 10));
        }
        System.out.println(list);

        list.stream()
                .distinct()
                .collect(Collectors.toCollection(TreeSet::new))
                .forEach(x -> System.out.print(x + " "));

    }
}
