package part2.task5;

import java.time.*;

import java.time.temporal.TemporalAdjusters;

public class Solution {
    public static void main(String[] args) {
        LocalDate dateToday = LocalDate.now();

        LocalDate datePrevFriday = dateToday.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
        LocalDate dateNextFriday = dateToday.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));


        System.out.println("Сегодня " + dateToday + ". День недели " + dateToday.getDayOfWeek());
        System.out.println("Дата предыдущей пятницы " + datePrevFriday);
        System.out.println("Дата следующей пятницы " + dateNextFriday);

    }
}
