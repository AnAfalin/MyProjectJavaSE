package inheritance.part2.task2;

public class Square extends Figure{
    private int side;


    public Square(String color, int side) {
        super(color);
        this.side = side;
    }

    @Override
    public double square() {
        return side*side;
    }
}
