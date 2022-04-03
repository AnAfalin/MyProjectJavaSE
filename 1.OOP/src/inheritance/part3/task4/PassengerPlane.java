package inheritance.part3.task4;

public class PassengerPlane extends Plane {
    private int countPassengers;

    public PassengerPlane(int speed, int fuel, int consumptionFuel, int countPassengers) {
        super(speed, fuel, consumptionFuel);
        this.countPassengers = countPassengers;
    }

    @Override
    public void fly(String point, int distance) {
        System.out.println("Перевозка пассажирским лайнером " + countPassengers + " людей");
        super.fly(point, distance);

    }
}
