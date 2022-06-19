package part2.task5;

import java.util.function.Function;

public class Solution {
    public static void main(String[] args) {
        int num1 = 1;
        int num2 = 4;

        Function<Integer, String> function = (n) -> Integer.toString(n);
        String res = method(function, num1, num2);
        System.out.println(res);
    }

    public static String method(Function<Integer, String> function, int number1, int number2){
        return function.apply(number1) + function.apply(number2);
    }
}
