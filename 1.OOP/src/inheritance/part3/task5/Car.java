package inheritance.part3.task5;

public class Car extends Transport{
    private final int CONSUMPTION_FUEL = 15;


    @Override
    public void drive(int kilometers) {
        System.out.println("Машина проехала " + kilometers + " и потратил " + (double) kilometers * CONSUMPTION_FUEL / 100 + " л.");
    }
}
