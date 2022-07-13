package part1.task13;

import java.time.Duration;
import java.time.LocalTime;
import java.util.*;

public class Solution {
    public static void main(String[] args) {

        Map<LocalTime, Integer> scheduleTrain = getScheduleTrain();

        System.out.println("Время отправления = Время в пути");
        scheduleTrain
                .forEach((key, value) -> System.out.println(key + "=" + value));
    }

    public static Map<LocalTime, Integer> getScheduleTrain() {
        Map<LocalTime, Integer> map = new LinkedHashMap<>();
        LocalTime departure = LocalTime.of(0, 0, 0);
        LocalTime arrive;
        int min = 0;

        Random random = new Random();
        while (min < Duration.ofDays(1).toMinutes()) {

            int departureMin = random.nextInt(40, 60);
            departure = departure.plusMinutes(departureMin);
            min += departureMin;
            int travelMin = random.nextInt(15, 40);
            map.put(departure, travelMin);
        }
        return map;
    }
/*
    public static void  methodVar(){
        LocalTime current = LocalTime.of(0, 0);

        SortedSet<LocalTime> timetable = new TreeSet<>();
        int totalMinutes = 0;
        do{
            timetable.add(current);
            int rand = new Random().nextInt(40, 60);
            current = current.plusMinutes(rand);
            totalMinutes += rand;
        }while (totalMinutes < Duration.ofDays(1).toMinutes());

        timetable.
                forEach(System.out::println);
    }
*/

}

