package sort.quickSort;

import java.util.Arrays;

//быстрая сортировка

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {8, 0, 4, 7, 3, 7, 10, 12, -3 };
        System.out.println("Было");
        System.out.println(Arrays.toString(array));
        quickSort(array, 0, array.length-1);
        System.out.println("Стало");
        System.out.println(Arrays.toString(array));
    }

    private static void quickSort(int[] array, int beginElement, int endElement) {
        //выбираем опорный элемент
        int middle = beginElement + (endElement - beginElement) / 2;
        int support = array[middle];

        //делим массив на подмассивы, которые больше и меньше опорного элемента
        int i = beginElement, j = endElement;
        while (i<=j){
            while (array[i] < support) {
                i++;
            }

            while (array[j] > support) {
                j--;
            }

            if(i<=j) {//меняем местами
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (beginElement < j)
            quickSort(array, beginElement, j);

        if (endElement > i)
            quickSort(array, i, endElement);
    }

}
