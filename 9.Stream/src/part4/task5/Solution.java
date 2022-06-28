package part4.task5;

import java.util.Arrays;
import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        int[] array = {10, 5, 15, 20};
        System.out.println(
                Arrays
                        .stream(array)
                        .average()
                        .orElseGet(() -> new Random().nextInt(0, 10))
        );

        System.out.println(
                Arrays
                        .stream(array)
                        .average()
                        .orElse(new Random().nextInt(0, 10))
        );


        int[] arr = new int[0];
        System.out.println(
                Arrays
                        .stream(arr)
                        .average()
                        .orElse(new Random().nextInt(0, 10))
        );

        System.out.println(
                Arrays
                        .stream(arr)
                        .average()
                        .orElseGet(() -> new Random().nextInt(0, 10))
        );

    }
}
