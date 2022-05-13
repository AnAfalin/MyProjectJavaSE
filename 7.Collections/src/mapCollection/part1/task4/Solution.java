package mapCollection.part1.task4;

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

        Integer[] arr = new Integer[map.size()];
        map.keySet().toArray(arr);
        Arrays.sort(arr);
        LinkedHashMap<Integer, Double> linkedHashMap = new LinkedHashMap<>();
        for (int i = 0; i < arr.length; i++) {
            linkedHashMap.put(arr[i], map.get(arr[i]));
        }
        System.out.println(linkedHashMap);

    }
}
