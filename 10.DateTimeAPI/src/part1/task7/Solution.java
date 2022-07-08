package part1.task7;

import java.time.*;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Solution {
    public static void main(String[] args) {
        LocalTime timeNow = LocalTime.now();
        LocalTime time = LocalTime.of(20, 00, 00);

        Duration duration = Duration.between(time, timeNow);
        System.out.println("Длительность между " + timeNow.format(DateTimeFormatter.ofPattern("hh:mm:ss")) + " и " + time + " составляет " + duration.toHoursPart() + " ч.");
        System.out.println("Длительность между " + timeNow.format(DateTimeFormatter.ofPattern("hh:mm:ss")) + " и " + time + " составляет " + duration.toMinutesPart() + " м.");
        System.out.println("Длительность между " + timeNow.format(DateTimeFormatter.ofPattern("hh:mm:ss")) + " и " + time + " составляет " + duration.toSecondsPart() + " с.");
        System.out.println("Длительность между " + timeNow.format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS")) +" и " + time + " составляет " + duration.toMillisPart() + " мс.");

        System.out.println(ChronoUnit.HOURS.between(time, timeNow));
        System.out.println(ChronoUnit.MINUTES.between(time, timeNow));
        System.out.println(ChronoUnit.SECONDS.between(time, timeNow));
        System.out.println(ChronoUnit.MILLIS.between(time, timeNow));


    }
}
