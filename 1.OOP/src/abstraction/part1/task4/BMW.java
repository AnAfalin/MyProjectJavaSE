package abstraction.part1.task4;

public class BMW extends Car{
    private int countStep;
    public static final String TITLE = "BMW";

    public BMW() {
        super(180, 20, 0.7);
    }

    public int getCountStep() {
        return countStep;
    }

    @Override
    public int doStep(int distance) {
        countStep++;
        return super.doStep(distance);
    }

}
