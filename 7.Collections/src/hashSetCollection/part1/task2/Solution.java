package hashSetCollection.part1.task2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add((int)(Math.random() * 10));
        }
        System.out.println(list);

        HashSet<Integer> hashSet = new HashSet<>();
        for (Integer el:list) {
            hashSet.add(el);
        }
        System.out.println(hashSet);
    }
}
