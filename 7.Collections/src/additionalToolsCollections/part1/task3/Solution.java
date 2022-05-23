package additionalToolsCollections.part1.task3;

import java.util.*;

public class Solution {
    public static void main(String[] args) {

        TreeSet<Integer> treeSet = new TreeSet<>();
        Random random = new Random();

        System.out.println("Исходные значения TreeSet");
        for (int i = 0; i < 10; i++) {
            treeSet.add(random.nextInt(50, 101));
        }

        System.out.println(treeSet);

        System.out.println("Вывод TreeSet в обратном порядке");
        System.out.println(treeSet.descendingSet());
    }
}
