package basics.part3.task4;

public class Main {
    public static void main(String[] args) {
        Square box = new Square(5, 5, 5);
        System.out.println(box);
        Expander exp = new Expander();
        exp.expand(box);
        System.out.println(box);

    }
}
