package tasks.part2.task3;

import java.util.Arrays;
import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        changeArray(array);
        System.out.println(Arrays.toString(array));
        int key = new Random().nextInt(1, 7);
        System.out.println("key " + key);
        int index = getIndex(array, key);
        System.out.println("index key " + index);
    }

    public static void changeArray(int[] array) {
        int offsetIndex = new Random().nextInt(6);
        while (offsetIndex != 0) {
            int current = array[0];
            for (int i = 0; i < array.length - 1; i++) {
                array[i] = array[i + 1];
            }
            array[array.length - 1] = current;
            offsetIndex--;
        }
    }

    public static int getIndex(int[] array, int key) {
        //O(log n)
        int pivotElement = findPivotElement(array);

        //O(log n)
        if (pivotElement == 0) {
            return foundIndex(array, 0, array.length - 1, key);
        } else if (key <= array[pivotElement - 1] && key > array[0]) {
            return foundIndex(array, 0, pivotElement, key);
        } else {
            return foundIndex(array, pivotElement + 1, array.length - 1, key);
        }

    }

    public static int findPivotElement(int[] array) {
        int lowIndex = 0;
        int highIndex = array.length - 1;
        while (lowIndex != highIndex && highIndex - lowIndex != 1){
            int middle = (highIndex + lowIndex) / 2;
            if(array[middle] < array[lowIndex]){
                highIndex = middle;
            }else if(array[middle] >= array[lowIndex]){
                lowIndex = middle;
            }
        }
        return lowIndex;
    }

    public static int foundIndex(int[] array, int beginIndex, int endIndex, int key) {
        int lowIndex = beginIndex;
        int highIndex = endIndex;
        int index = -1;
        while (lowIndex <= highIndex) {
            int middle = lowIndex + ((highIndex - lowIndex) / 2);
            if (key < array[middle]) {
                highIndex = middle - 1;
            } else if (key > array[middle]) {
                lowIndex = middle + 1;
            } else {
                index = middle;
                break;
            }
        }
        return index;
    }
}

