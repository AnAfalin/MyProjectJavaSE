package abstraction.part1.task1;

public class Main {
    public static void main(String[] args) {
        Square square = new Square("Black", 5);
        System.out.println("Square`s diagonal is " + square.calculateDiagonal());
        System.out.println("Square`s perimeter is " + square.calculatePerimeter());
        System.out.println("Square`s area is " + square.calculateArea());
        System.out.println("Square`s color is " + square.getColor());

        Circle circle = new Circle("White", 2);
        System.out.println("Square`s diagonal is " + circle.getRadius());
        System.out.println("Square`s perimeter is " + circle.calculatePerimeter());
        System.out.println("Square`s area is " + circle.calculateArea());
        System.out.println("Square`s color is " + circle.getColor());

    }
}
