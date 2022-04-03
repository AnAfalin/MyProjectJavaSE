package polymorphism.part2.task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Currency currency;
        boolean isCorrect = false;


        while (!isCorrect) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите валюту, которую ходите обменять на рубли: DOLLAR, EUR");
            String enterUser = scanner.nextLine();
            if (enterUser.equalsIgnoreCase("DOLLAR")) {
                currency = new USD(100);
                System.out.println(currency.exchange(100));
                isCorrect = true;
            } else if (enterUser.equalsIgnoreCase("EURO")) {
                currency = new EUR(90);
                System.out.println(currency.exchange(100));
                isCorrect = true;
            } else System.out.println("Вы ввели недействительную валюту. Повторите ввод");
        }
    }
}
