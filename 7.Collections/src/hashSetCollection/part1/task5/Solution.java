package hashSetCollection.part1.task5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add((int) (Math.random() * 9));
        }
        Collections.sort(list);
        System.out.println("Исходный отсортированный список");
        System.out.println(list);

        HashSet<Integer> hashSet = new HashSet<>(list);
        System.out.println(hashSet);
        list.clear();
        list.addAll(hashSet);
        System.out.println(list);
    }
}
