package part3.task5;

public class Square extends Figure {
    private double side;
    private static int count;

    public Square(double side) {
        this.side = side;
        count++;
    }

    public int getCount() {
        return count;
    }
}
