package part1.task14;

import java.time.Duration;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {

        Map<LocalTime, Integer> scheduleTrain = getScheduleTrain();

        System.out.println("Время отправления = Время прибытия -- Время в пути");
        scheduleTrain
                .forEach((key, value) -> System.out.println(key + "-" + "-" + value +"-" + key.plusMinutes(value)));

        System.out.println("Введите время отправления");
        LocalTime inputTime = LocalTime.parse(new Scanner(System.in).nextLine());

        System.out.println("Введите время в пути");
        int timeTravel = Integer.parseInt(new Scanner(System.in).nextLine());

        LocalTime timeArrive = inputTime.plusMinutes(timeTravel);
        System.out.println(inputTime + "-" + timeTravel + "-" + timeArrive);


        LocalTime prevLocalTime = scheduleTrain.entrySet()
                .stream()
                .map(el -> el.getKey().plusMinutes(el.getValue()))
                .filter(time -> time.isBefore(timeArrive))
                .toList()
                .stream()
                .sorted((o1, o2) -> o2.compareTo(o1))
                .findFirst()
                .get();

        LocalTime lastLocalTime = scheduleTrain.entrySet()
                .stream()
                .filter(time -> time.getKey().isAfter(timeArrive))
                .map(el -> el.getKey())
                .collect(Collectors.toList())
                .stream()
                .sorted((o1, o2) -> o2.compareTo(o1))
                .findFirst()
                .get();

        if((prevLocalTime.isBefore(inputTime) || prevLocalTime == inputTime) && (inputTime.isBefore(lastLocalTime) || inputTime == lastLocalTime)){
            System.out.println("Рейс добавлен");
            scheduleTrain.put(inputTime, timeTravel);
        }else {
            System.out.println("Error! Данный рейс добавить нельзя, т.к. происходит накладка");
        }
        System.out.println(scheduleTrain);
    }

    public static Map<LocalTime, Integer> getScheduleTrain() {
        Map<LocalTime, Integer> map = new TreeMap<>();
        LocalTime departure = LocalTime.of(0, 0, 0);
        LocalTime arrive;
        int min = 0;

        while (min < Duration.ofDays(1).toMinutes()) {

            int departureMin = new Random().nextInt(40, 60);
            departure = departure.plusMinutes(departureMin);
            min += departureMin;
            int travelMin = new Random().nextInt(15, 40);
            arrive = departure.plusMinutes(travelMin);
            min += travelMin;
            map.put(departure, travelMin);
            departure = arrive;
        }
        return map;
    }
}

