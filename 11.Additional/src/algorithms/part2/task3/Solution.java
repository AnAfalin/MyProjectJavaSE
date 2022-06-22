package algorithms.part2.task3;

import java.util.Arrays;
import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};

        int offsetIndex = new Random().nextInt(6);
        while (offsetIndex != 0) {
            int current = array[0];
            for (int i = 0; i < array.length - 1; i++) {
                array[i] = array[i + 1];
            }
            array[array.length - 1] = current;
            offsetIndex--;
        }
        System.out.println(Arrays.toString(array));

        int key = new Random().nextInt(1,7);
        System.out.println(key);
        int low = 0;
        int row = array.length - 1;
        int index = low + (row - low) / 2;
        while (key != array[index]) {
            if((key < array[index] && key < array[low]) || (key > array[index] && key <= array[row])){
                low = index + 1;
            }else if((key < array[index] && key > array[low]) || (key < array[index] && key >= array[low])){
                row = index - 1;
            }
            index = low + (row - low) / 2;
        }
        System.out.println(index);

    }
}

