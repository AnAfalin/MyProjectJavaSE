package polymorphism.part2.task3;

public class Polynomial3 implements Polynomial {

    @Override
    public int evaluate(int x) {
        return (x * x) + x + 1;
    }
}
