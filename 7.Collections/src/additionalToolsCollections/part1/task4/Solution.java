package additionalToolsCollections.part1.task4;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Integer[] array = new Integer[20];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt( 10);
            System.out.print(array[i] + " ");
        }
        System.out.println();

        Map<Integer, Integer> hashMap = new HashMap<>();

        for (Integer el:array) {
            if(hashMap.containsKey(el)){
                hashMap.put(el, hashMap.get(el) + 1);
            }else {
                hashMap.put(el, 1);
            }
        }

        int index = 0;
        Set<Map.Entry<Integer, Integer>> entries = hashMap.entrySet();
        for (Map.Entry<Integer, Integer> el:entries) {
            for (int i = 0; i < el.getValue(); i++) {
                array[index] = el.getKey();
                index++;
            }
        }

        System.out.println(hashMap);
        System.out.println(Arrays.toString(array));
    }
}
