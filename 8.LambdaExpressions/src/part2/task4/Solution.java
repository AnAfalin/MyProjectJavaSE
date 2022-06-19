package part2.task4;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Solution {
    public static void main(String[] args) {
        int num1 = 1;
        int num2 = 4;

        Function<Integer, String> function = (n) -> Integer.toString(n);
        String res1 = function1(function, num1, num2);
        System.out.println(res1);

        BiFunction<Integer, Integer, String> biFunction = (n1, n2) -> n1 + Integer.toString(n2);
        String res2 = function2(biFunction, num1, num2);
        System.out.println(res2);
    }

    public static String function1(Function<Integer, String> function, int number1, int number2){
        return function.apply(number1) + function.apply(number2);
    }

    public static String function2(BiFunction<Integer, Integer, String> biFunction, int number1, int number2){
        return biFunction.apply(number1, number2);
    }
}
