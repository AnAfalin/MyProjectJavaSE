package part3.task5;

public class Circle extends Figure {
    private double radius;
    private static int count;

    public Circle(double radius) {
        this.radius = radius;
        count++;
    }

    public int getCount() {
        return count;
    }
}
