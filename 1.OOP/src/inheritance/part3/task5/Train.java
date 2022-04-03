package inheritance.part3.task5;

public class Train extends Transport{
    private final int CONSUMPTION_FUEL = 30;

    @Override
    public void drive(int kilometers) {
        System.out.println("Поезд проехал " + kilometers + " и потратил " + (double) kilometers * CONSUMPTION_FUEL + " л.");
    }
}
