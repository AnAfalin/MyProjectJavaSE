package polymorphism.part2.task4;


import polymorphism.part2.task3.Polynomial;
import polymorphism.part2.task3.Polynomial1;
import polymorphism.part2.task3.Polynomial2;
import polymorphism.part2.task3.Polynomial3;

public class ResultPolynomials {
    public static int sumResPol(Polynomial[] polynomials, int x) {
        int result = 0;
        for (Polynomial el:polynomials) {
            result += el.evaluate(x);
        }
        return result;
    }

    public static void main(String[] args) {
        Polynomial[] polynomials = {
                new Polynomial1(),
                new Polynomial2(),
                new Polynomial3(),
        };

        System.out.println(sumResPol(polynomials, 5));
    }
}
