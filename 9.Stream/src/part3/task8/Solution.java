package part3.task8;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class Solution {
    public static int[] array = new int[10_000_000];

    public static void main(String[] args) {
        fillArray();
        streamSort();
        streamParallelSort();

        System.out.println();
        streamSum();
        streamParallelSum();

        System.out.println();
        streamGrouping();
        streamParallelGrouping();

    }

    public static void fillArray() {
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(0, 5);
            //System.out.print(array[i] + " ");
        }
        //System.out.println();
    }

    public static void streamSort() {
        long startTime = System.nanoTime();
        Arrays.stream(array)
                .sorted();
        long endTime = System.nanoTime();
        long time = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println(time + " - Время сортировки в обычном потоке");
    }

    public static void streamParallelSort() {
        long startTime = System.nanoTime();
        Arrays.stream(array)
                .parallel()
                .sorted();
        long endTime = System.nanoTime();
        long time = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println(time + " - Время сортировки в параллельном потоке");
    }

    public static void streamSum() {
        long startTime = System.nanoTime();
        Arrays.stream(array)
                .sum();
        long endTime = System.nanoTime();
        long time = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println(time + " - Время суммирования в обычном потоке");
    }

    public static void streamParallelSum() {
        long startTime = System.nanoTime();
        Arrays.stream(array)
                .parallel()
                .sum();
        long endTime = System.nanoTime();
        long time = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println(time + " - Время суммирования в параллельном потоке ");
    }

    public static void streamGrouping() {
        long startTime = System.nanoTime();
        Arrays.stream(array)
                .boxed()
                .collect(Collectors.groupingBy(
                        el -> el,
                        Collectors.summingInt(el -> 1)));
                /*.entrySet()
                .stream()
                .forEach(entry -> System.out.print(entry + " "))*/;
        long endTime = System.nanoTime();
        long time = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println(time + " - Время группировки в обычном потоке ");
    }

    public static void streamParallelGrouping() {
        long startTime = System.nanoTime();
        Arrays.stream(array)
                .boxed()
                .parallel()
                .collect(Collectors.groupingBy(
                        el -> el,
                        Collectors.summingInt(el -> 1)));
                /*.entrySet()
                .stream()
                .forEach(entry -> System.out.print(entry + " "))*/;
        long endTime = System.nanoTime();
        long time = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println(time + " - Время группировки в паралелльное потоке");
    }
}
