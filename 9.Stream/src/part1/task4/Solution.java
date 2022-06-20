package part1.task4;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {

        Stream.
                iterate(0, x -> new Random().nextInt(10))
                .limit(1000)
                .limit(1)
                .forEach(System.out::println);
    }
}
