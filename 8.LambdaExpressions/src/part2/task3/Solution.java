package part2.task3;

import java.util.function.*;

public class Solution {
    public static void main(String[] args) {
        //UnaryOperator<Double> sqrt = (n) -> Math.sqrt(n);
        UnaryOperator<Double> sqrt = Math::sqrt;

        //Consumer<Integer> print = (n) -> System.out.println(n);
        Consumer<Integer> print = System.out::println;

        //UnaryOperator<Double> log10 = (n) -> Math.log10(n);
        UnaryOperator<Double> log10 = Math::log10;

        //BiFunction<Integer, Integer, Double> pow = (n1, n2) -> Math.pow(n1, n2);
        BiFunction<Integer, Integer, Double> pow = Math::pow;

        //Supplier<Double> getRandomDouble = () -> Math.random();
        Supplier<Double> getRandomDouble = Math::random;

    }
}
