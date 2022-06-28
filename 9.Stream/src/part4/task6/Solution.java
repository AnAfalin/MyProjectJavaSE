package part4.task6;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        List<int[]> listArrays = new LinkedList<>();
        full(listArrays);
        print(listArrays);

        System.out.println(average(listArrays));

        listArrays
                .stream()
                .flatMapToDouble(x -> Arrays.stream(x).asDoubleStream())
                .average()
                .ifPresent(System.out::println);


    }

    public static void full(List<int[]> list) {
        for (int i = 0; i < 10; i++) {
            int x = new Random().nextInt(0, 2);
            if (x == 0) {
                list.add(i, new int[0]);
            } else {
                int[] array = new int[new Random().nextInt(1, 5)];
                for (int j = 0; j < array.length; j++) {
                    array[j] = new Random().nextInt(0, 10);
                }
                list.add(i, array);
            }
        }
    }

    public static void print(List<int[]> list) {
        for (int[] ints : list) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static double average(List<int[]> list) {
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                index = i;
                break;
            }
        }
        int count = 0;
        int sum = 0;
        for (int i = index; i < list.size(); i++) {
            if (list.get(i) != null) {
                count += list.get(i).length;
                for (int el : list.get(i)) {
                    sum += el;
                }
            }
        }
        return (double) sum / count;
    }
}
