package part1.task1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(10, 20, 30, 40, 50));
        double[] array = new double[]{60.0, 70.0, 80.0, 90.0, 100.0};

        Stream<Integer> streamOfList = list.stream();
        DoubleStream streamOfArray = Arrays.stream(array);
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);

        streamOfList.forEach(el-> System.out.print(el + " "));
        System.out.println();
        streamOfArray.forEach(el-> System.out.print(el + " "));
        System.out.println();
        stream.forEach(el-> System.out.print(el + " "));

    }
}
