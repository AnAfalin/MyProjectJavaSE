package encapsulation.task1;
/*

 */
public class Square {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double area(){
        return side * side;
    }

    public double perimeter() {
        return 4 * side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
}
