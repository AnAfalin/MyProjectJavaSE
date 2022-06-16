package part1.task6;

import java.util.function.UnaryOperator;

public class Solution {
    public static int parameter;

    public static void main(String[] args) {

        parameter = 5;
        UnaryOperator<Integer> unaryOperator = increment(parameter);
        int num2 = unaryOperator.apply(parameter);
        System.out.println(parameter);
        System.out.println(num2);


    }

    public static UnaryOperator<Integer> increment(int param) {
        parameter++;
        return p -> p + 1;
    }
}
