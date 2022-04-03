package abstraction.part1.task4;

public class Lada extends Car{
    private int countStep;
    public static final String TITLE = "Lada";

    public Lada( ) {
        super(120, 15, 0.3);
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
