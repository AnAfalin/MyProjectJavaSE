package abstraction.part1.task2;

public class EUR extends Currency{

    public EUR(double courseToRub) {
        super(courseToRub);
    }

    @Override
    public double exchange(int volume) {
        System.out.println("EUR --> RUB");
        return super.exchange(volume);
    }
}
