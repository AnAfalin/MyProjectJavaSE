package part3.task5;

public class Triangle extends Figure {
    private double sideА;
    private double sideB;
    private double sideC;
    private static int count;

    public Triangle(double sideА, double sideB, double sideC) {
        this.sideА = sideА;
        this.sideB = sideB;
        this.sideC = sideC;
        count++;
    }

    public int getCount() {
        return count;
    }
}
