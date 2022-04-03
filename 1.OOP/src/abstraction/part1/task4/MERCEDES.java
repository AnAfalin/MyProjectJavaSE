package abstraction.part1.task4;

public class MERCEDES extends Car{
    private int countStep;

    public MERCEDES() {
        super(170, 25, 0.3);
    }

    @Override
    public int doStep(int distance) {
        countStep++;
        return super.doStep(distance);
    }

    public int getCountStep() {
        return countStep;
    }
}
