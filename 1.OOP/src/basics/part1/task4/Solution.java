package basics.part1.task4;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = (int)(Math.random() * 20 - 10); //Math.random() * (max - min) + min;
            System.out.print(array[i] + "   ");
        }
        System.out.println();
        int[] resArray = new int[10];
        for (int i = 0; i < 10; i++) {
             if(array[i] < 0){
                array[i] = array[i]  * (-1);
            }
            resArray[array[i]]++;
        }
        System.out.println(Arrays.toString(resArray));

        for (int i = 0; i < resArray.length; i++) {
            if (resArray[i] != 0) {
                System.out.println((i) + " - " + resArray[i] + " раз");
            }
        }
    }
}
