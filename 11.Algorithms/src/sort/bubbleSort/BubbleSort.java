package sort.bubbleSort;

//сортировка пузырьком

public class BubbleSort {


    public static void main(String[] args) {
        int[] array = {10, 5, 8, 2};
        sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void sort (int[] array) { //O(n^2)
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {

                if(array[i] > array[j]) {
                    int tmp = array[j];
                    array[j] = array[i];
                    array[i] = tmp;
                }
            }
        }
    }




}

