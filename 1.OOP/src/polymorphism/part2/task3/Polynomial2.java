package polymorphism.part2.task3;

public class Polynomial2 implements Polynomial {

    @Override
    public int evaluate(int x) {
        return (x * x * x) + (x * x) + x + 1;
    }
}
