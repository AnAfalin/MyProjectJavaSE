package algorithms.part1.task2;

public class MathOperations {
    public static <T extends Number> int delete(T number1, T number2) {
        int res = 0;
        double num1 = number1.doubleValue();
        while (num1 >= number2.doubleValue()) {
            num1 -= number2.doubleValue();
            res++;
        }
        return res;
    }
}
