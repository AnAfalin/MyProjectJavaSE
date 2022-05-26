package iteratorClass.task5;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        SortedSet<Integer> set = new TreeSet<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            set.add(random.nextInt(100));
        }
        System.out.println(set);
        set = set.headSet(30);
        System.out.println(set);
    }
}
