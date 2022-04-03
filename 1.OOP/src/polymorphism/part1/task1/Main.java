package polymorphism.part1.task1;

public class Main {
    public static void main(String[] args) {
        Figure[] arrayFigures = {
                new Circle(10),
                new Square(10),
                new Triangle(5, 3, 4),
                new Square(5),
                new Square(1),
                new Triangle(4, 2, 2),
                new Circle(8),
                new Square(9)
        };

        double sumAreas = 0.0;
        double sumPerimeters = 0.0;
        for (Figure el:arrayFigures) {
            sumAreas += el.calculateArea();
            sumPerimeters += el.calculatePerimeter();
        }
        System.out.println("Сумма площадей фигур равна " + sumAreas);
        System.out.println("Сумма периметров фигур равна " +sumPerimeters);
    }
}
