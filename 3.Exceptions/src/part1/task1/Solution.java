package part1.task1;

public class Solution {
    public static void main(String[] args) {
        System.out.println(divide(10, 2));
        System.out.println(divide(1, 0));
    }

    public static double divide(int a, int b) {
        double result;
        try {
            result = (double)(a / b);
        }catch (ArithmeticException exception){
            System.out.print("Произошла ошибка: ");
            System.out.println(exception.getMessage());
        }finally {
            b = 1;
            result = (a / b);
        }
        return result;
    }
}
