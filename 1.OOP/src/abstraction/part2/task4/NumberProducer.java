package abstraction.part2.task4;

import java.util.Random;
import java.util.Scanner;

public class NumberProducer implements Producer{
    private boolean isRandom;

    void changeState(boolean state){
        isRandom = !isRandom;
    }

    public NumberProducer(boolean isRandom) {
        this.isRandom = isRandom;
    }

    @Override
    public double getNumber() {
        if(isRandom) {
            return Math.random() * 100;
        }else {
            System.out.println("Введите число");
            return new Scanner(System.in).nextDouble();
        }
    }
}
