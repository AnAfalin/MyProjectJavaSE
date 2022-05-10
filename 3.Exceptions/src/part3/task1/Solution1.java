package part3.task1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution1 {
    public static void main(String[] args) {

        do {
            try {
                Scanner scanner = new Scanner(System.in);
                String expression = scanner.nextLine();
                Pattern pattern = Pattern.compile("[0-9]+|[/*-+]");
                Matcher matcher = pattern.matcher(expression);
                ArrayList<String> array = new ArrayList<>();

                while (matcher.find()) {
                    array.add(matcher.group());
                }
                double num1 = Double.parseDouble(array.get(0));
                double num2 = Double.parseDouble(array.get(2));
                double result = switch (array.get(1)) {
                    case "*" -> num1 * num2;
                    case "/" -> num1 / num2;
                    case "+" -> num1 + num2;
                    case "-" -> num1 - num2;
                    default -> Double.NaN;
                };
                System.out.println(result);
                break;
            }
            catch (Exception e){
                System.out.println("Неверный ввод");
            }
        } while (true);
    }
}

