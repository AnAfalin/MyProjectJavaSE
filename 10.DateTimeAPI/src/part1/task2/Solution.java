package part1.task2;

import java.time.LocalDate;
import java.time.LocalTime;

public class Solution {
    public static void main(String[] args) {
        String date = "2022-07-15";
        LocalDate localDate = LocalDate.parse(date);
        System.out.println(localDate);

        String time = "15:30:05"; // 15часов 30 минут 05 секунд
        LocalTime localTime = LocalTime.parse(time);
        System.out.println(localTime);
    }
}
