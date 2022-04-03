package abstraction.part1.task2;

public class Main {
    public static void main(String[] args) {
        USD usd = new USD(90);
        System.out.println(usd.exchange(1));
        EUR eur = new EUR(110);
        System.out.println(eur.exchange(2));
    }
}
