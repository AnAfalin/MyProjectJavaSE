package part2.task3;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Solution {
    public static void main(String[] args) {

        List<LocalDate> array = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int year = random.nextInt(2000, 2023);
            int month = random.nextInt(1, 13);
            array.add(LocalDate.of(year, month, 15));
        }
        array.forEach(System.out::println);

        System.out.println("---");

        LocalDate epoch = LocalDate.of(1970, 1, 1);

        System.out.println(ChronoUnit.DAYS.between(epoch, array.get(0)));

        long averageDays = (long) array.stream()
                .map(el -> ChronoUnit.DAYS.between(epoch, el))
                .mapToInt(Long::intValue)
                .average()
                .orElse(0);

        LocalDate mediumDate = LocalDate.ofEpochDay(averageDays);

        System.out.println(mediumDate);


    }
}
