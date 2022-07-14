package part2.task2;

import java.time.LocalTime;
import java.time.Year;

public class Solution {
    public static void main(String[] args) {
        Year year = Year.now();;
        int seconds = year.length() * ((LocalTime.MAX.getHour()) + 1) * ((LocalTime.MAX.getMinute()) + 1) * ((LocalTime.MAX.getSecond()) + 1);
        System.out.println("В " + year + " году " + seconds + " сек.");
    }
}
