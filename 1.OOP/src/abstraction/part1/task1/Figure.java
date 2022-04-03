package abstraction.part1.task1;

public abstract class Figure {
    private String color;

    public Figure(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public abstract double calculateArea();
    public abstract double calculatePerimeter();

}
