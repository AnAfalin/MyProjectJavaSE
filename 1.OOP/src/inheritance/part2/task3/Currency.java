package inheritance.part2.task3;

public class Currency {
    double courseToRub;

    public Currency(double courseToRub) {
        this.courseToRub = courseToRub;
    }

    public double exchange(int volume) {
        return volume * courseToRub;
    }
}
