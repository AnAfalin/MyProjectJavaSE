package hashSetCollection.part1.task3;

import java.util.*;

public class Solution1 {
    public static void main(String[] args) {
        int[] arrayOfNumber = new int[5];
        for (int i = 0; i < arrayOfNumber.length; i++) {
            arrayOfNumber[i] = (int)(Math.random() * 9);
            System.out.print(arrayOfNumber[i] + " ");
        }
        System.out.println();

        Set<Integer> set = new HashSet<>();
        for (int i:arrayOfNumber) {
            set.add(i);
        }

        System.out.println(set);

        int num = new Scanner(System.in).nextInt();

        int count = 0;

        //O(n)
        for (int i = 0; i < arrayOfNumber.length; i++){     //O(n)
            int value = num - arrayOfNumber[i];
            if (set.contains(value)) {      //O(1)
                count++;
            }
        }

        System.out.println(count / 2 );
    }
}
