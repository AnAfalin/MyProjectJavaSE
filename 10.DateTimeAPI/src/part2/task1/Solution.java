package part2.task1;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Solution {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime date = LocalDateTime.now().minusHours(35);

        long between = ChronoUnit.HOURS.between(date, now);
        System.out.println("Между датами " + between + " час.");
        double l = (double) between / (Duration.ofDays(1).toHours());
        System.out.printf("%.2f дня", l);
    }
}
