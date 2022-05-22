package collectionTreeSetTreeMap.part1.task2;

import java.util.Arrays;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        Integer[] array = new Integer[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 10);
        }
        System.out.println("Массив\n" + Arrays.toString(array));

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        for (Integer el : array) {
            if (treeMap.containsKey(el)) {
                treeMap.put(el, treeMap.get(el) + 1);
            } else {
                treeMap.put(el, 1);
            }
        }

        System.out.println("Элемент - количетсво вхождений элемента в массив");
        System.out.println(treeMap);
    }
}
