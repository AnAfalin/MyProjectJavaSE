package abstraction.part1.task2;

public class USD extends Currency{

    public USD(double courseToRub) {
        super(courseToRub);
    }

    @Override
    public double exchange(int volume) {
        System.out.println("USD--> RUB");
        return super.exchange(volume);
    }
}
