package part1.task8;

import java.time.LocalDate;
import java.time.Month;

public class Solution {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2022, Month.APRIL, 1);
        LocalDate date2 = LocalDate.of(2022, Month.JULY, 1);

        if(date1.isAfter(date2)){
            System.out.println(date1 + " после " + date2);
        }else {
            System.out.println(date2 + " после " + date1);

        }
    }
}
