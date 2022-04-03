package polymorphism.part2.task1;

public class EUR extends Currency {

    public EUR(double courseToRub) {
        super(courseToRub);
    }

    @Override
    public double exchange(int volume) {
        System.out.println("Exchange " + volume + " EUR --> RUB");
        return super.exchange(volume);
    }
}
