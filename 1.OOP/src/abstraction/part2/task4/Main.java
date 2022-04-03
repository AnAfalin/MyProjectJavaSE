package abstraction.part2.task4;

public class Main {
    public static void main(String[] args) {
        NumberProducer np1 = new NumberProducer(true);
        System.out.println(np1.getNumber());
        NumberProducer np2 = new NumberProducer(false);
        System.out.println(np2.getNumber());
    }
}
