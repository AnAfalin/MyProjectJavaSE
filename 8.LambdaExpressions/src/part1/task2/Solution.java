package part1.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Solution {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1, 30, 15, 38, 10, 15, 55));

        Predicate<Integer> filter = new Predicate<>() {
            @Override
            public boolean test(Integer integer) {
                String number = Integer.toString(integer);
                int sum = 0;
                for (int i = 0; i < number.length(); i++) {
                    sum += Integer.parseInt(Character.toString(number.charAt(i)));
                }
                return sum < 10;
            }
        };

        list.removeIf(filter);

        System.out.println(list);
    }
}
