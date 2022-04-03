package inheritance.part2.task3;

public class EUR extends Currency{

    public EUR(double courseToRub) {
        super(courseToRub);
    }

    @Override
    public double exchange(int volume) {
        return volume * courseToRub;
    }
}
