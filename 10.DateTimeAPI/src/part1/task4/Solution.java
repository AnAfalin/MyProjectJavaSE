package part1.task4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Solution {
    public static void main(String[] args) {
        String strDate = "20:03:2021";
        LocalDate date = LocalDate.parse(strDate, DateTimeFormatter.ofPattern("dd:MM:yyyy"));
        System.out.println(date);
    }
}
