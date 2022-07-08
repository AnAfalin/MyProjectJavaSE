package part1.task5;

import java.time.LocalDate;
import java.time.Month;

public class Solution {
    public static void main(String[] args) {
        LocalDate localDate1 = LocalDate.of(2020, Month.JULY, 10);
        LocalDate localDate2 = LocalDate.of(2022, Month.JULY, 10);
        isLeapYearPrint(localDate1);
        isLeapYearPrint(localDate2);
    }

    public static void isLeapYearPrint(LocalDate localDate){
        if(localDate.isLeapYear()){
            System.out.println("год " + localDate.getYear() + " високосный");
        }else {
            System.out.println("год " + localDate.getYear() + " не является високосным");
        }
    }
}
