package mapCollection.part1.task5;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Map<Integer, Double> map = new HashMap<>();
        map.put(5, 5.0*5.0);
        map.put(55, 55.0*55.0);
        map.put(2, 2.0*2.0);
        map.put(23, 23.0*23.0);
        map.put(44, 44.0*44.0);
        map.put(10, 10.0*10.0);
        map.put(3, 3.0*3.0);
        System.out.println(map);

        Set<Integer> set = map.keySet();
        for (Integer el:set) {
            System.out.println(el + "-" + map.get(el));
        }

    }
}
