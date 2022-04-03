package polymorphism.part1.task1;

public class Circle extends Figure{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() { // L = d*π = 2*r*π
        return Math.PI * 2 * radius;
    }
}
