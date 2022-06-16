package part1.task6;

public class Solution {
    public static void main(String[] args) {

        int num1 = 5;
        UnaryOperator<Integer> unaryOperator = (el) -> el + 1;
        int num2 = unaryOperator.apply(num1);
        System.out.println(num2);

    }

}
