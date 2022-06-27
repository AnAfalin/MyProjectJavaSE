package part4.task1;

import java.util.Optional;

public class Solution {
    public static void main(String[] args) {
        Integer number = 55;

        Optional<Integer> optionalNumber = Optional.of(number);
        optionalNumber.ifPresentOrElse(System.out::println, () -> System.out.println("null element"));

        Optional<Integer> optionalEmpty = Optional.empty();
        optionalEmpty.ifPresentOrElse(System.out::println, () -> System.out.println("null element"));

        Integer numberNull = null;
        Optional<Integer> optionalNullElement = Optional.ofNullable(numberNull);
        optionalNullElement.ifPresentOrElse(System.out::println, () -> System.out.println("null element"));
    }
}
