package part2.task3;

import java.time.LocalDate;
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
            int month = random.nextInt(01, 13);
            array.add(LocalDate.of(year, month, 15));
        }
        array.forEach(System.out::println);

        System.out.println("---");

        /*Как правильно получить значение в Optional*/
        LocalDate min = array
                .stream()
                .min(LocalDate::compareTo)
                .get();

        LocalDate max = array
                .stream()
                .max(LocalDate::compareTo)
                .get();

        System.out.println("Самая ранняя дата " + min);
        System.out.println("Самая поздняя дата " + max);
        long mediumBetween = ChronoUnit.DAYS.between(min, max) / 2;
        LocalDate mediumDate = min.plusDays(mediumBetween);
        System.out.println("Срединная дата " + mediumDate);

    }
}
