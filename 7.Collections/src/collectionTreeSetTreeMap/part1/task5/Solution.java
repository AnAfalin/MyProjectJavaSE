package collectionTreeSetTreeMap.part1.task5;

import java.util.Random;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        Random random = new Random();

        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 1; i <= 10; i++) {
            int r = random.nextInt(100);
            treeSet.add(r);
        }
        System.out.println("Набор случайных чисел в TreeSet " + treeSet);

        System.out.println("Ближайшее большее число к 50 - " + treeSet.higher(50));
        System.out.println("Ближайшее меньшее число к 50 - " + treeSet.lower(50));

    }
}
