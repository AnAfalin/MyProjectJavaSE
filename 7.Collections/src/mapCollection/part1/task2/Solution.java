package mapCollection.part1.task2;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] array = new int[10];
        System.out.println("Исходный массив");
        for (int i = 0; i < 10; i++) {
            array[i] = (int) (Math.random() * 10);
            System.out.print(array[i] + " ");
        }
        System.out.println();

        Map<Integer, Integer> map = new HashMap<>();
        Collection<Integer> values = map.values();

        for (int i = 0; i < array.length; i++) {
            int k = array[i];
            int v = 0;
            for (int j = 0; j < array.length; j++) {
                if(k == array[j]){
                    v++;
                }
            }
            map.put(k, v);
        }
        System.out.println("Полученная Map коллекция, где К - уникальное число из массива, V - количество посторений этого числа в массиве");
        System.out.println(map);
    }
    
}
