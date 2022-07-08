package part1.task1;

import java.time.LocalDate;
import java.time.Month;

public class Solution {
    public static void main(String[] args) {
        LocalDate today1 = LocalDate.of(2022, Month.JULY, 8);
        LocalDate today2 = LocalDate.now();

        System.out.println(today1);
        System.out.println(today2);
    }
}
