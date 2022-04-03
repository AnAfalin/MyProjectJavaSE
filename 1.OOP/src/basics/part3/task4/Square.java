package basics.part3.task4;

public class Square {
    private int width;
    private int height;
    private int depth;

    public Square(int width, int height, int depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int volume() {
        return (width * height * depth);
    }

    @Override
    public String toString() {
        return "Коробка. " +
                " Ширина=" + width +
                ", Высота=" + height +
                ", Глубина=" + depth +
                '}';
    }
}
