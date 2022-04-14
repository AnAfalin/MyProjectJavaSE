package part2.task5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static <T> void copy(List<? super T> listIn, List<? extends T> listFrom){
        for (T element : listFrom) {
            listIn.add(element);
        }

    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        List<Integer> list1 = new ArrayList<>();
        System.out.println(list1);
        copy(list1, list);
        System.out.println(list1);
    }
}
