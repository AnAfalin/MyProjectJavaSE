package part1.task10;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class Solution {
    public static void main(String[] args) {
        LocalDate dateJAVA = LocalDate.of(1995, Month.MAY, 23);

        Period yearsOldJAVA = Period.between(dateJAVA, LocalDate.now());
        System.out.println(yearsOldJAVA.getYears() + " лет " + yearsOldJAVA.getMonths() + " месяц " + yearsOldJAVA.getDays() + " дней");

    }
}
