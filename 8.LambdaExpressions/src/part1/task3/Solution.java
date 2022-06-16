package part1.task3;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<String> listString = new ArrayList<>(List.of("10", "20", "30", "40", "50"));
        List<Integer> listInteger = new ArrayList<>();
        listString.forEach(el -> listInteger.add(Integer.parseInt(el)));
        System.out.println(listInteger);
    }
}
