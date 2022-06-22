package algorithms.part2.task2;

import java.util.Arrays;


public class Solution {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};

        //O(n)
        int res = 1;
        for (int i = 0; i < array.length; i++) {
            res *= array[i];
        }
        //O(n)
        for (int i = 0; i < array.length; i++) {
            array[i] = res / array[i];
        }

        System.out.println(Arrays.toString(array));

        //O(n) + O(n) = O(2n) = O(n)
    }

}
