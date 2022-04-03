package polymorphism.part2.task2;

public class Circle extends Figure{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculatePerimeter() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

}
