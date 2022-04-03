package polymorphism.part2.task1;

public class USD extends Currency {

    public USD(double courseToRub) {
        super(courseToRub);
    }

    @Override
    public double exchange(int volume) {
        System.out.println("Exchange " + volume + " USD --> RUB");
        return super.exchange(volume);
    }
}
