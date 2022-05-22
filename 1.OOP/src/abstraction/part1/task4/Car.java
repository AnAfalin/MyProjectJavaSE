package abstraction.part1.task4;

public abstract class Car {
    private int speed;
    private int fuel;
    private int consumptionFuel;
    private double probabilityDamage;
    private int countStep;


    public Car(int speed, int consumptionFuel, double probabilityDamage) {
        this.speed = speed;
        this.consumptionFuel = consumptionFuel;
        this.probabilityDamage = probabilityDamage;
        this.fuel = 50;
    }

    public int doStep(int kilometers) {
        int distance = kilometers;
//        while (kilometres > 0) {
        double randomProbabilityDamage = Math.random();
        if (fuel - consumptionFuel <= 0) {
            System.out.println("Мало топлива. Заправка");
            fuel = 50;
        } else if (randomProbabilityDamage <= probabilityDamage) {
            System.out.println("Машина сломалась. Починка");
        } else {
            fuel -= consumptionFuel;
            distance -= speed;
        }
        countStep++;
        return distance;
    }

    public int getCountStep() {
        return countStep;
    }
}

