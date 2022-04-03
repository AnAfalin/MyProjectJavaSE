package inheritance.part3.task5;

public class Transport {
    private int consumptionFuel;
    private static int count;

    public Transport() {
        count++;
    }

    public static int getCount() {
        return count;
    }

    public void drive(int kilometers){
        System.out.println("Данный вид транспорта проехал " + kilometers + " и потратил " + (double) kilometers * consumptionFuel / 100 + " л.");
    }

}
