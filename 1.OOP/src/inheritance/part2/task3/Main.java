package inheritance.part2.task3;

public class Main {
    public static void main(String[] args) {
        EUR eur = new EUR(40);
        System.out.println(eur.exchange(5));
        USD usd = new USD(80);
        System.out.println(usd.exchange(1));
    }
}
