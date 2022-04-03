package inheritance.part2.task2;

public class Circle extends Figure {
    private int radius;


    public Circle(String color, int diameter) {
        super(color);
        this.radius = diameter;
    }

    @Override
    public double square() {
        return Math.PI * (radius * 2);
    }
}
