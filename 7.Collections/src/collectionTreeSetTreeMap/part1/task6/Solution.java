package collectionTreeSetTreeMap.part1.task6;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        //поиск в TreeSet - O(log(n))
        //поиск в HashSet - O(1)

        int n = 16;
        Set<Integer> treeSet = new TreeSet<>();
        Set<Integer> hashSet = new HashSet<>();
        addSet(treeSet, 1000000);
        addSet(hashSet, 1000000);
        System.out.println("Поиск одного и того же элемента составляет ");
        System.out.print("В реализации TreeSet интефейса Set: " + compareSearchSpeed(hashSet, 255_555) + " наносекунд\n");
        System.out.print("В реализации HashSet интефейса Set: " + compareSearchSpeed(hashSet, 255_555) + " наносекунд\n");
    }

    public static void addSet(Set<Integer> set, int count){
        for (int i = 0; i < count; i++) {
            set.add(i);
        }
    }

    public static boolean contains(Set<Integer> set, int el){
        return set.contains(el);
    }

    public static long compareSearchSpeed(Set<Integer> set, int el){
        long begin = System.nanoTime();
        contains(set, el);
        long end = System.nanoTime();
        return (end - begin);
    }
}
