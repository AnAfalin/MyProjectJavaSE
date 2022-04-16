package part3.task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClassSolution<T> {
    public static <T extends Comparable<T>> void sort(List<T> list){
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                T objI = list.get(i);
                T objJ = list.get(j);
                if(objI.compareTo(objJ) > 0){
                    list.set(i, objJ);
                    list.set(j, objI);
//                    list.remove(j);
//                    list.add(i, objJ);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(50);
        list.add(40);
        list.add(30);
        list.add(20);
        list.add(10);

        System.out.println(list);
        ClassSolution.sort(list);
        System.out.println(list);

    }
}



