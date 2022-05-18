package hashSetCollection.part1.task3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        int[] arrayOfNumber = new int[20];
        for (int i = 0; i < arrayOfNumber.length; i++) {
            arrayOfNumber[i] = (int)(Math.random() * 9);
            System.out.print(arrayOfNumber[i] + " ");
        }
        int num = new Scanner(System.in).nextInt();

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < arrayOfNumber.length; i++) {
            for (int j = 0; j < arrayOfNumber.length; j++) {
                if(i == j){
                    continue;
                }
                if(arrayOfNumber[i] + arrayOfNumber[j] == num){
                    hashMap.put(arrayOfNumber[i], arrayOfNumber[j]);
                }
            }
        }
        System.out.println(hashMap);


    }
}
