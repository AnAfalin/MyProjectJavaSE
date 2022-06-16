package part1.task2;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1, 3, 5, 8, 10, 15, 20));
        list.removeIf(el -> el < 10);
        System.out.println(list);
    }
}
