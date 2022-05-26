package iteratorClass.task1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(40, 50, 60, 70, 80, 90, 30, 20, 10));

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            int el = iterator.next();
            System.out.println(el);
        }
    }
}
