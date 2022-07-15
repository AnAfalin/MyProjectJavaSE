package part2.task2;

import java.time.Duration;
import java.time.Year;
import java.time.temporal.ChronoUnit;

public class Solution {
    public static void main(String[] args) {
        Year year = Year.now();;

        long seconds = Duration.of(Year.of(year.getValue()).length(), ChronoUnit.DAYS).toSeconds();
        System.out.println("В " + year + " году " + seconds + " сек.");
    }
}
