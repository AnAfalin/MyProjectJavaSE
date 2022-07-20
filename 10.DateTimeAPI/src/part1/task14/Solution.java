package part1.task14;

import java.time.Duration;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {

        NavigableMap<LocalTime, Integer> scheduleTrain = getScheduleTrain();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Время отправления = Время прибытия -- Время в пути");
        scheduleTrain
                .forEach((key, value) -> System.out.println(key + "-" + "-" + value +"-" + key.plusMinutes(value)));

        System.out.println("Введите время отправления");
        LocalTime departureTime = LocalTime.parse(scanner.nextLine());

        System.out.println("Введите время в пути");
        int timeTravel = Integer.parseInt(scanner.nextLine());
        LocalTime timeArrive = departureTime.plusMinutes(timeTravel);

        System.out.println(departureTime + "-" + timeTravel + "-" + timeArrive);

        if(isAddTrain(scheduleTrain, departureTime,timeArrive)){
            scheduleTrain.put(departureTime, timeTravel);
            System.out.println("Рейс добавлен");
            System.out.println("\nНовое расписание:\nВремя отправления = Время прибытия -- Время в пути");
            scheduleTrain
                    .forEach((key, value) -> System.out.println(key + "-" + "-" + value +"-" + key.plusMinutes(value)));
        }else {
            System.out.println("Error! Данный рейс добавить нельзя, т.к. происходит накладка");
        }


    }

    public static boolean isAddTrain(NavigableMap<LocalTime, Integer> scheduleTrain,
                                     LocalTime departureTime, LocalTime timeArrive){

        Map.Entry<LocalTime, Integer> lowerTrain = scheduleTrain.lowerEntry(departureTime);
        Map.Entry<LocalTime, Integer> higherTrain = scheduleTrain.higherEntry(departureTime);
        Map.Entry<LocalTime, Integer> firstTrain = scheduleTrain.firstEntry();
        Map.Entry<LocalTime, Integer> lastTrain = scheduleTrain.lastEntry();

         if(lowerTrain == null){

            return (higherTrain.getKey().isAfter(timeArrive) || higherTrain.getKey().equals(timeArrive))
                    && (lastTrain.getKey().plusMinutes(lastTrain.getValue()).isBefore(departureTime) || lastTrain.getKey().plusMinutes(lastTrain.getValue()).equals(departureTime));

        } else if (higherTrain == null) {
            return (lowerTrain.getKey().plusMinutes(lowerTrain.getValue()).isBefore(departureTime) || lowerTrain.getKey().plusMinutes(lowerTrain.getValue()).equals(departureTime))
                    && (firstTrain.getKey().isAfter(timeArrive) || firstTrain.getKey().equals(timeArrive));

        }
         return (lowerTrain.getKey().plusMinutes(lowerTrain.getValue()).isBefore(departureTime) || lowerTrain.getKey().plusMinutes(lowerTrain.getValue()).equals(departureTime))
                 && (higherTrain.getKey().isAfter(timeArrive) || higherTrain.getKey().equals(timeArrive));
    }

    public static NavigableMap<LocalTime, Integer> getScheduleTrain() {
        NavigableMap<LocalTime, Integer> map = new TreeMap<>();
        LocalTime departure = LocalTime.of(0, 0, 0);
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
}

