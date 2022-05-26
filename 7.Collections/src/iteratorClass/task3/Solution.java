package iteratorClass.task3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println(list);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            int el = iterator.next();
            if(el % 2 == 0){
                iterator.remove();
            }
        }
        System.out.println(list);
    }
}
