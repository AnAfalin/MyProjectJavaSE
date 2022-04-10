package part2.subpart1.task1;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Solution {
    public static double calculation(int x, int y) { // x! / (y + y^2)
        if (y != 0) {
            return (double) (calculationFact(x)) / (y + y * y);
        }
        throw new ArithmeticException("Недопустимое значение второго параметра");
    }

    private static int calculationFact(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("Значение не может быть отрицательным");
        }
        return factorial(x);
    }

    private static int factorial(int x) {
        int result = 1;
        if (x > 0) {
            return x * factorial(x - 1);
        } else
            return result;
    }

    public static void saveResult(String infoResMethod) throws IOException {
        File file = new File("result.txt");
        FileWriter writer = new FileWriter(file);
        writer.write(infoResMethod);
        writer.close();
    }
}

class Variant1 {
    public static void main(String[] args) {

        int x = 3;
        int y = 5;
        System.out.println("Вычисление выражения  x! / (y + y^2)");
        try {
            double result = Solution.calculation(x, y);
            String str = "Результат равен: " + result;
            System.out.println(str);
            Solution.saveResult(str);
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class Variant2 {
    public static void main(String[] args) {

        int x = 3;
        int y = 0;
        System.out.println("Вычисление выражения  x! / (y + y^2)");
        try {
            double result = Solution.calculation(x, y);
            String str = "Результат равен: " + result;
            System.out.println(str);
            Solution.saveResult(str);
        } catch (IllegalArgumentException | ArithmeticException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}