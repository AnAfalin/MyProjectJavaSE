package part2.task3;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static <T extends Number> double sumOfTwoList(List<T> list1, List<T> list2){
        return sumElementOfListT(list1) + sumElementOfListT(list2);
    }

    private static <T extends Number> double sumElementOfListT (List<T> list){
        double sum = 0;
        for (Number el : list) {
            sum += el.doubleValue();
        }
        return sum;
    }
}

class Main{
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(10);
        list1.add(20);
        list1.add(30);
        list1.add(40);


        List<Integer> list2 = new ArrayList<>();
        list1.add(100);
        list1.add(200);

        System.out.println(Solution.sumOfTwoList(list1, list2));
    }
}