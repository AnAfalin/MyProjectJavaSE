package hashSetCollection.part1.task5;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            list.add(random.nextInt(100, 200));
        }
        Collections.sort(list);
        System.out.println("Исходный отсортированный список");
        System.out.println(list);

        Set<Integer> hashSet = new LinkedHashSet<>(list);
        System.out.println(hashSet);

        list.clear();
        list.addAll(hashSet);

        System.out.println("Отсортированный список без дубликатов");
        System.out.println(list);
    }
}
