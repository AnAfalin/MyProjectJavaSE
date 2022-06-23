package part2.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new Random().nextInt(1, 10));
        }
        System.out.println(list);

        //1
        list.stream().distinct().forEach(x-> System.out.print(x + " "));

        //2
        list.stream()
                .collect(Collectors.toSet())
                .stream()
                .forEach(x->System.out.print(x + " "));
    }
}
