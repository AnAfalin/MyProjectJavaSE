package mapCollection.part1.task1;

import java.util.*;

public class Solution {
    public static void main(String[] args) {

        int[] arrayNumber = new int[10];
        for (int i = 0; i < 10; i++) {
            int number = (int)(Math.random() * 10 + 1);
            arrayNumber[number - 1] += 1;
        }

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < arrayNumber.length; i++) {
            map.put(Integer.toString(i + 1), arrayNumber[i]);
        }

        Collection<Integer> collection = map.values();
        String number = "";
        int max = Integer.MIN_VALUE;
        Set<String> set = map.keySet();
        for (String key : set){
            if(map.get(key) > max) {
                max = map.get(key);
                number = key;
            }
        }

        System.out.println(number + " было загадано больше всего");
    }
}
