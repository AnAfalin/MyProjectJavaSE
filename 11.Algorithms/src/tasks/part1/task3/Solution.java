package tasks.part1.task3;

public class Solution {
    public static int binarySearch(int[] array, int el) {
        int lowIndex = 0;
        int highIndex = array.length - 1;
        while (lowIndex <= highIndex){
            int middle = lowIndex + (highIndex - lowIndex) / 2;
            if(el < array[middle]){
                highIndex = middle - 1;
            }else if(el > array[middle]){
                lowIndex = middle + 1;
            }else {
                return middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        int el1 = 19;
        int el2 = 9;

        System.out.println(binarySearch(array, el1));
        System.out.println(binarySearch(array, el2));
    }
}

