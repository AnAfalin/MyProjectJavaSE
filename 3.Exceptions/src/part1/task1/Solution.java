package part1.task1;

public class Solution {
    public static void main(String[] args) {
        try {
            System.out.println(divide(10, 0));
        }
        catch (ArithmeticException exception){
            System.out.println("Произошла ошибка: ");
            System.out.println(exception.getMessage());
        }
        finally {
            System.out.println("finally");
        }
    }

    public static double divide(int a, int b) {
        return a / b;
    }
}
