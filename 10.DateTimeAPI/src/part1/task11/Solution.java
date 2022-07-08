package part1.task11;

import java.time.LocalDate;

public class Solution {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();

        System.out.println("Через 100 дней будет " + date.plusDays(100).getDayOfWeek());
        System.out.println("Через 3 месяца будет " + date.plusMonths(3).getDayOfWeek());
        System.out.println("Через неделю будет " + date.plusWeeks(1).getDayOfWeek());
        System.out.println("Через год будет " + date.plusYears(1).getDayOfWeek());
    }
}
