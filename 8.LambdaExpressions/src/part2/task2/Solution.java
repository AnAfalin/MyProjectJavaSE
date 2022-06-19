package part2.task2;

import java.util.List;
import java.util.function.Consumer;

public class Solution {

    public static void main(String[] args) {
        int number = 5;

        Consumer<Integer> consumer1 = (num) -> System.out.println("элемент равен " + num + ", метод - первый");
        Consumer<Integer> consumer2 = (num) -> System.out.println("элемент равен " + num + ", метод - второй");
        Consumer<Integer> consumer3 = (num) -> System.out.println("элемент равен " + num + ", метод - третий");
        Consumer<Integer> consumer4 = (num) -> System.out.println("элемент равен " + num + ", метод - четвертый");
        Consumer<Integer> consumer5 = (num) -> System.out.println("элемент равен " + num + ", метод - пятый");

        List<Consumer<Integer>> consumerList = List.of(consumer1, consumer2, consumer3, consumer4, consumer5);

        fiveMethods(consumerList, number);

    }

    public static void fiveMethods(List<Consumer<Integer>> consumerList, int number){
        for (Consumer<Integer> consumer:consumerList) {
            consumer.accept(number);
        }
    }

}
