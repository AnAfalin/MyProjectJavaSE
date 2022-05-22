package hashSetCollection.part1.task3;


import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int[] arrayOfNumber = new int[10];
        for (int i = 0; i < arrayOfNumber.length; i++) {
            arrayOfNumber[i] = (int)(Math.random() * 9);
            System.out.print(arrayOfNumber[i] + " ");
        }
        System.out.println();
        int num = new Scanner(System.in).nextInt();


        Set<Integer> set = new HashSet<>();
        for (int i:arrayOfNumber) {
            set.add(i);
        }

        int count = 0;
        for (int i = 0; i < arrayOfNumber.length; i++) {
            int value = num - arrayOfNumber[i];
            if(set.contains(value)){
                count++;
            }
        }
        System.out.println(count);


    }
}
