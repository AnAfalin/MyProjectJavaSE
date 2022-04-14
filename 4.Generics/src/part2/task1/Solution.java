package part2.task1;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void printListOfNumber(List<? extends Number> list){
        for (Number num:list) {
            System.out.println(num);
        }
    }
}

class Main{
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        Solution.printListOfNumber(list);

        List<Double> list1 = new ArrayList<>();
        list1.add(1.0);
        list1.add(2.0);
        list1.add(3.0);
        list1.add(4.0);
        list1.add(5.0);
        Solution.printListOfNumber(list1);
    }
}
