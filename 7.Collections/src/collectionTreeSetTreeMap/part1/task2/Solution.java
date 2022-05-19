package collectionTreeSetTreeMap.part1.task2;

import java.util.Arrays;
import java.util.Collections;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        Integer[] array = new Integer[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 10);
        }
        System.out.println("Массив\n" + Arrays.toString(array));

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        Collections.addAll(treeSet, array);

        for (Integer el:treeSet) {
            int count = 0;
            for (int i = 0; i < array.length; i++) {
                if(el.equals(array[i])){
                    count++;
                }
            }
            treeMap.put(el, count);

        }
        System.out.println("Элемент - количетсво вхождений элемента в массив");
        System.out.println(treeMap);
    }
}
