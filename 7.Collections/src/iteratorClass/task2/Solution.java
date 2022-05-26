package iteratorClass.task2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int r = random.nextInt(10);
            System.out.print(r + " ");
            if(map.containsKey(r)){
                map.put(r, Integer.toString(Integer.parseInt(map.get(r)) + 1));
            }else {
                map.put(r, Integer.toString(1));
            }
        }
        System.out.println();

        Iterator<Map.Entry<Integer, String>>  iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, String> el = iterator.next();
            System.out.println(el);
        }
    }
}
