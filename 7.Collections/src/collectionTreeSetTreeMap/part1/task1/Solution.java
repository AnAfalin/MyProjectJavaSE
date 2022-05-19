package collectionTreeSetTreeMap.part1.task1;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{55, 25, 10, 5, 75, 20, 30, 60, 80, 70};
        System.out.println("Array \n" + Arrays.toString(array));
        TreeSet<Integer> treeSet = new TreeSet<>();

        Collections.addAll(treeSet, array);
        System.out.println("TreeSet \n" + treeSet);

        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = treeSet.last();
            treeSet.remove(treeSet.last());
        }
        System.out.println("Array past sort \n" + Arrays.toString(array));
    }
}
