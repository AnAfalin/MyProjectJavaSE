package abstraction.part3.task3;

public class ArithmeticConsumer implements Consumer{
    @Override
    public double calculate(int numberFirst, int numberSecond, String operation) {
        return switch (operation) {
            case "+" -> numberFirst + numberSecond;
            case "-" -> numberFirst - numberSecond;
            case "*" -> numberFirst * numberSecond;
            case "/" -> (double) numberFirst / numberSecond;
            default -> 0;
        };
    }
}
