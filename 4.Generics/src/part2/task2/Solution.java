package part2.task2;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static double sumElementOfListWC (List<? super Integer> list){
        double sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += (Integer) list.get(i);
        }
        return sum;
    }
    public static <T> double sumElementOfListT (List<T> list){
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += (Integer) list.get(i);
        }
        return sum;
    }
}

class Main{
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        System.out.println(Solution.sumElementOfListT(list));
        System.out.println(Solution.sumElementOfListWC(list));
    }
}