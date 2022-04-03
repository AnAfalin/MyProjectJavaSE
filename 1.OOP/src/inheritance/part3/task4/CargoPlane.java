package inheritance.part3.task4;

public class CargoPlane extends Plane {
    private int cargo;

    public CargoPlane(int speed, int fuel, int consumptionFuel, int cargo) {
        super(speed, fuel, consumptionFuel);
        this.cargo = cargo;
    }

    @Override
    public void fly(String point, int distance) {
        System.out.println("Перевозка грузовым самолетом " + cargo + " килограмм груза");
        super.fly(point, distance);
    }
}
