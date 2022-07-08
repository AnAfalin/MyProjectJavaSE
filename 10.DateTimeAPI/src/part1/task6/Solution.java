package part1.task6;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class Solution {
    public static void main(String[] args) {
        LocalDate dateNow = LocalDate.now();
        LocalDate date = LocalDate.of(1994, Month.APRIL, 17);

        Period between = Period.between(date, dateNow);
        System.out.println("Между датой " + dateNow + " и датой " + date + " : " +
                "\t" + between.getYears() + " лет " + between.getMonths() + " месяца " + between.getDays() + " дней");

        System.out.println("Общее количество: ");
        System.out.println("лет = " + (dateNow.getYear() + date.getYear()));
        System.out.println("месяцев = " + ((dateNow.getMonthValue() * dateNow.getYear()) + (date.getMonthValue() * date.getYear())));
        System.out.println("дней = " + (dateNow.getDayOfYear() * dateNow.getYear()) + (date.getDayOfYear() * date.getYear()));
    }
}
