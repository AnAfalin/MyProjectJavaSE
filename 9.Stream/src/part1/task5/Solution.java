package part1.task5;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {

        double[] arrayDouble = {1.0, 2.0, 3.0, 4.0, 5.0};

        Arrays.stream(arrayDouble).map(el -> el * 2).forEach(System.out::println);

    }
}
