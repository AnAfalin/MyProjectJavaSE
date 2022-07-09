package part1.task6;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Solution {
    public static void main(String[] args) {
        LocalDate dateNow = LocalDate.now();
        LocalDate date = LocalDate.of(1994, Month.APRIL, 17);

        Period between = Period.between(date, dateNow);
        System.out.println("Между датой " + dateNow + " и датой " + date + " : " +
                + between.getYears() + " лет " + between.getMonths() + " месяца " + between.getDays() + " дней");

        System.out.println("Общее количество: ");
        System.out.println("лет = " + ChronoUnit.YEARS.between(date, dateNow));
        System.out.println("месяцев = " + ChronoUnit.MONTHS.between(date, dateNow));
        System.out.println("дней = " + ChronoUnit.DAYS.between(date, dateNow));
    }
}
