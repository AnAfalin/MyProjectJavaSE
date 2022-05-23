package additionalToolsCollections.part1.task4;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Integer[] array = new Integer[20];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt( 50);
            System.out.print(array[i] + " ");
        }
        System.out.println();

        Queue<Integer> list = new PriorityQueue<>(List.of(array));

        for (int i = 0; i < array.length; i++) {    //O(n)
            array[i] = list.poll();                 //O(1)
        }

        for (Integer el:array) {
            System.out.print(el + " ");
        }

        //Arrays.sort(array); // O(n*log(n))
    }
}
