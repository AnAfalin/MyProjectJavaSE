package mapCollection.part1.task1;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            int number = (int)(Math.random() * 10 + 1);
            if(map.containsKey(Integer.toString(number))){
                map.put(Integer.toString(number), map.get(Integer.toString(number)) + 1);
            }else {
                map.put(Integer.toString(number), 1);
            }
        }
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        String number = "";
        int min = 0;
        for (var el:entrySet) {

            if(el.getValue() > min){
                min = el.getValue();
                number = el.getKey();
            }
        }

        System.out.println(map);

        System.out.println(number + " было загадано больше всего");
    }
}
