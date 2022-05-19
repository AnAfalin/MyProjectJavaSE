package collectionTreeSetTreeMap.part1.task1;

import java.util.*;

public class Solution1 {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{55, 20, 10, 55, 20};
        System.out.println("Array \n" + Arrays.toString(array));
        TreeSet<Integer> treeSet = new TreeSet<>();

        Queue<Integer> queue = new PriorityQueue<>();
        Collections.addAll(queue, array);
        System.out.println("Elements past sort \n" +queue);
        for (int i = 0 ; i < array.length; i++) {
            array[i] = queue.remove();
        }
        System.out.println("Array past sort \n" + Arrays.toString(array));
    }
}
