package inheritance.part2.task3;

public class USD extends Currency{

    public USD(double courseToRub) {
        super(courseToRub);
    }

    @Override
    public double exchange(int volume) {
        return volume * courseToRub;
    }
}
