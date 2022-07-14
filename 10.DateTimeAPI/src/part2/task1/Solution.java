package part2.task1;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Solution {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime date = LocalDateTime.now().minusHours(35);

        double between = (double) ChronoUnit.HOURS.between(date, now);
        System.out.println("Между датами " + between + " час.");
        double l = between / (LocalDateTime.MAX.getHour() + 1);
        System.out.printf("%.2f дня", l);
    }
}
