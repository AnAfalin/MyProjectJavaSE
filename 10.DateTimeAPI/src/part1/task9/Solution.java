package part1.task9;

import java.time.LocalDate;
import java.time.Month;

public class Solution {
    public static void main(String[] args) {
        LocalDate dateStart = LocalDate.of(2000, Month.JANUARY, 1);
        LocalDate dateEnd = LocalDate.of(2022, Month.JANUARY, 1);

        int countLeapYear = 0;
        LocalDate current = dateStart;

        System.out.println("Список високосных годов между " + dateStart.getYear() + " и " + dateEnd.getYear());
        while (current.getYear() != dateEnd.getYear()){
            if(current.isLeapYear()){
                countLeapYear++;
                System.out.println(current.getYear());
            }
            current = current.plusYears(1);
        }

        System.out.println("Количество годов " + countLeapYear);
    }
}
