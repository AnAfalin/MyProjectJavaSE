package polymorphism.part2.task2;

public class Calculator {
    public static double calculatorPerimeter(Figure[] figures){
        double sumPerimeters = 0;
        for (Figure el:figures) {
            sumPerimeters += el.calculatePerimeter();
        }
        return sumPerimeters;
    }

    public static double calculatorArea(Figure[] figures){
        double sumAreas = 0;
        for (Figure el:figures) {
            sumAreas += el.calculateArea();
        }
        return sumAreas;
    }

    public static void main(String[] args) {
        Figure[] figures = {
                new Circle(5),
                new Rectangle(4, 8),
                new Square(10),
                new Triangle(2, 2, 2)
        };

        System.out.println(calculatorPerimeter(figures));
        System.out.println(calculatorArea(figures));
    }
}
