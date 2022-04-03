package polymorphism.part2.task3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Polynomial polynomial;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число для расчета");
        int number = scanner.nextInt();
        System.out.print("Выберите формулу, по которой хотите произвести расчет:\n1. x + 1\n2. x^2 + x + 1\n3. x^3 + x^2 + x + 1\n");
        int enterUser = scanner.nextInt();
        switch (enterUser) {
            case 1 -> polynomial = new Polynomial1();
            case 2 -> polynomial = new Polynomial2();
            case 3 -> polynomial = new Polynomial3();
            default -> polynomial = null;
        }
        if(polynomial != null) {
            System.out.println(polynomial.evaluate(number));
        }
    }
}
