package abstraction.part1.task1;

public class Square extends Figure{
    private double side;

    public Square(String color, double side) {
        super(color);
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return side * side;
    }

    @Override
    public double calculatePerimeter() {
        return 4 * side;
    }

    public double calculateDiagonal(){
        return side * Math.sqrt(2);
    }
}
