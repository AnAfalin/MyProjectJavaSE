package part1.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Random().nextInt(10));
        }
        System.out.println(list);

        list.stream()                                           //создание потока из последовательности чисел
                .sorted((x1, x2)->Integer.compare(x2, x1))      //сортировка по убыванию
                .distinct()                                     //удаление дубликатов
                .skip(1)                                        //пропуск первого элемента
                .forEach(el-> System.out.print(el + " "));      //вывод со элемента - ВТОРОЙ максимум последовательности

        System.out.println();




    }
}
