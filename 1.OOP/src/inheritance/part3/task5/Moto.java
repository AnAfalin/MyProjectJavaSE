package inheritance.part3.task5;

public class Moto extends Transport{
    private final int CONSUMPTION_FUEL = 8;


    @Override
    public void drive(int kilometers) {
        System.out.println("Мотоцикл проехал " + kilometers + " и потратил " + (double) kilometers * CONSUMPTION_FUEL / 100 + " л.");
    }
}
