package abstraction.part1.task4;

public class KIA extends Car{
    private int countStep;
    public static final String TITLE = "KIA";

    public KIA() {
        super(110, 12, 0.3);
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
