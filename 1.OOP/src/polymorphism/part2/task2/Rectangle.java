package polymorphism.part2.task2;

public class Rectangle extends Figure{
    private double sideA;
    private double sideB;

    public Rectangle(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * sideA + 2 * sideB;
    }

    @Override
    public double calculateArea() {
        return sideA * sideB;
    }

}
