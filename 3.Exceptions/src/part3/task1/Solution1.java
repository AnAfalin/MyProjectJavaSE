package part3.task1;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String expression;
        do {
            expression = scanner.nextLine();
        } while (!expression.matches("\\d+ []/*-+] \\d+"));

        String[] elements = expression.split(" ");

        double num1 = Double.parseDouble(elements[0]);
        double num2 = Double.parseDouble(elements[2]);
        double result = switch (elements[1]) {
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            default -> Double.NaN;
        };
        System.out.println(result);
    }
}

