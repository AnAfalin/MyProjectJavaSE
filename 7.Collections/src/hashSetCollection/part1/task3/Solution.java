package hashSetCollection.part1.task3;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] arrayOfNumber = new int[5];
        for (int i = 0; i < arrayOfNumber.length; i++) {
            arrayOfNumber[i] = (int)(Math.random() * 9);
            System.out.print(arrayOfNumber[i] + " ");
        }
        System.out.println();

        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i:arrayOfNumber) {
            set.add(i);
            list.add(i);
        }
        System.out.println(set);
        System.out.println(list);

        int num = new Scanner(System.in).nextInt();

        int count = 0;

        for (int i = list.size() - 1; i > 0; i--){
            int value = num - list.get(i);
            if (set.contains(value)) {
                count++;
                list.remove(i);
            }
        }

        System.out.println(count);
    }
}
