package part1.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Solution {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(100, -10, 10, 200));
        System.out.println(list);

        Predicate<Integer> filter = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return !(integer >= 10 && integer <= 100);
            }
        };

        list.removeIf(el -> (el < 10 || el > 100));

        System.out.println(list);
    }
}
