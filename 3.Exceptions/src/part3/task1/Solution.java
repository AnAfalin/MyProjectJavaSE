package part3.task1;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        do {
            try {
                Scanner scanner = new Scanner(System.in);
                StringBuilder expression = new StringBuilder(scanner.nextLine());
                double num1 = Double.parseDouble(expression.substring(0, expression.indexOf(" ")));
                expression.delete(0, expression.indexOf(" ") + 1);
                char operation = expression.charAt(0);
                expression.delete(0, 2);
                double num2 = Double.parseDouble(expression.substring(0));
                double result = 0.0;
                if (operation == '*') {
                    result = num1 * num2;
                } else if (operation == '/') {
                    result = num1 / num2;
                } else if (operation == '+') {
                    result = num1 + num2;
                } else if (operation == '-') {
                    result = num1 - num2;
                }
                System.out.println(result);
                break;
            } catch (Exception e) {
                System.out.println("Ошибка. Повторите правильный ввод строки выражения в формате: \"число [operation] число\"");
            }
        } while (true);
    }
}

