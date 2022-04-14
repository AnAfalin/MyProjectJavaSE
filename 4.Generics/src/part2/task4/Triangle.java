package part2.task4;

public class Triangle extends Figure{
    private double sideА;
    private double sideB;
    private double sideC;

    public Triangle(double sideА, double sideB, double sideC) {
        this.sideА = sideА;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double calculateArea() {
        double p = calculatePerimeter() / 2;
        return Math.sqrt(p * (p - sideА) * (p - sideB) * (p - sideC));
    }

    private double calculatePerimeter() {
        return sideА + sideB + sideC;
    }
}
