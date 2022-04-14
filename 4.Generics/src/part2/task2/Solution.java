package part2.task2;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static double sumElementOfListWC (List<? extends Number> list){
        double sum = 0;
        for (Number el : list) {
            sum += el.doubleValue();
        }
        return sum;
    }

    public static <T extends Number> double sumElementOfListT (List<T> list){
        double sum = 0;
        for (Number el : list) {
            sum += el.doubleValue();
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