package part1.task3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Solution {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        System.out.println(currentDate);
        String strCurrentDate = currentDate.format(DateTimeFormatter.ofPattern("dd:MM:yyyy"));
        System.out.println(strCurrentDate);
    }
}
