package part1.task5;

import java.util.Arrays;
import java.util.function.Function;

public class Solution {
    public static void main(String[] args) {
        Function<Integer, String> function = (num) -> Integer.toString(num);
        Integer[] intArray = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] strArray = processArray(function, intArray);
        System.out.println(Arrays.toString(strArray));

    }

    public static <T> String[] processArray(Function<T, String> function, T[] array){
        String[] arr = new String[array.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = function.apply(array[i]);
        }
        return arr;
    }

}
