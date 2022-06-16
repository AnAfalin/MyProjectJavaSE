package algorithms.part1.task3;

public class Solution {
    public static int binarySearch(int[] array, int el) {
        return binarySearch(array, array.length - 1, el);
    }

    private static int binarySearch(int[] array, int toIndex, int el) {
        int index = (array.length) / 2 - 1;
        while (el != array[index]) {
            if(el > array[index]){
                if(toIndex <= array.length - 1){
                    index = toIndex;
                }else {
                    index = index + 1;
                }
            }else {
                toIndex = index - 1;
                index = index / 2;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        int el = 9;

        System.out.println(binarySearch(array, el));
    }
}

