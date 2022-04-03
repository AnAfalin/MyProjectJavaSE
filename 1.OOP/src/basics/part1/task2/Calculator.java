package basics.part1.task2;

public class Calculator {
    double numFirst;
    double numSecond;

    public Calculator(double numFirst, double numSecond) {
        this.numFirst = numFirst;
        this.numSecond = numSecond;
    }

    public void setNumFirst(double numFirst) {
        this.numFirst = numFirst;
    }

    public void setNumSecond(double numSecond) {
        this.numSecond = numSecond;
    }

    public double add() {
        return numFirst + numSecond;
    }

    public double sub() {
        return numFirst - numSecond;
    }
    public double mul() {
        return numFirst * numSecond;
    }
    public double div() {
        if(isNull(numFirst)) {
            return Double.NaN;
        }
        if (isNull(numSecond)) {
            if(numFirst > 0.0) {
                return Double.POSITIVE_INFINITY;
            }else return Double.NEGATIVE_INFINITY;
        }
        return numFirst / numSecond;
    }

    public int factorial(){
        int number = (int) numFirst;
        int res = 1;
        do {
            res = res * number;  //1*4*3*2
            number--;            //1
        }while (number>=1);
        return res;
    }

    private boolean isNull(double number) {
        if(number == 0.0) {
            return true;
        }
        return false;
    }
}

/*class start{
    public static void main(String[] args) {
        Calculator calculator = new Calculator(0.0, 4.5);
        double result = calculator.add();
        System.out.println("Результат сложения чисел в калькуляторе: " + result);
        System.out.println("Результат вычитания чисел в калькуляторе: " + calculator.sub());
        System.out.println("Результат умножения чисел в калькуляторе: " + calculator.mul());
        System.out.println("Результат деления чисел в калькуляторе: " + calculator.div());
        System.out.println(calculator.factorial());

    }
}
*/
