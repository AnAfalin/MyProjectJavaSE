package hashSetCollection.part1.task2;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 30; i++) {
            //list.add((int)(Math.random() * 10));
            int r = random.nextInt(1, 100);
            list.add(r);
        }
        System.out.println(list);

        Collections.sort(list);

        Set<Integer> set = new LinkedHashSet<>(list);

        list.clear();
        list.addAll(set);

        System.out.println(list);
    }
}
