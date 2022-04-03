package basics.part3.task2;

public class Square {
    private int side;

    public Square(int side) {
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    public int square() {
        return side * side;
    }

    public int perimeter() {
        return 4 * side;
    }

    public double diagonal() {
        return side * Math.sqrt(2);
    }

    @Override
    public String toString() {
        return "Квадрат со стороной равной " + side +
                "\nПериметр равен: " + this.perimeter() +
                "\nПлощадь равна: " + this.square() +
                "\nДиагональ равна " + this.diagonal();
    }
}
