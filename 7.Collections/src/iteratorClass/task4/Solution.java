package iteratorClass.task4;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            set.add(random.nextInt(100));
        }
        System.out.println(set);
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            int el = iterator.next();
            if(el % 2 != 0){
                iterator.remove();
            }
        }
        System.out.println(set);
    }
}
