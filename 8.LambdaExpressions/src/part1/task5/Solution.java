package part1.task5;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        MyFunction<Integer> myFunction = (num) -> Integer.toString(num);
        Integer[] intArray = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] strArray = processArray(myFunction, intArray);
        System.out.println(Arrays.toString(strArray));

    }

    public static <T> String[] processArray(MyFunction<T> myFunction, T[] array){
        String[] arr = new String[array.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = myFunction.toString(array[i]);
        }
        return arr;
    }

}
