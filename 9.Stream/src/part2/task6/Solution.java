package part2.task6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int st = new Random().nextInt(-10, 10);
        IntStream.range(st, st + 10).forEach(list::add);
        System.out.println(list);

        System.out.println("sum = " + list.stream().mapToInt(Integer::intValue).sum());

        if (list.stream().mapToInt(Integer::intValue).average().isPresent()) {
            System.out.println("average = " + list.stream().mapToInt(Integer::intValue).average().getAsDouble());
        }

        System.out.println("count of positive elements = " + list.stream().mapToInt(Integer::intValue).filter(x -> x > 0).count());

        System.out.println("count of negative elements = " + list.stream().mapToInt(Integer::intValue).filter(x -> x < 0).count());

    }
}
