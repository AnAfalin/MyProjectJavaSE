package inheritance.part3.task4;

public class Main {
    public static void main(String[] args) {
        PassengerPlane pasPlane = new PassengerPlane(700, 210_000, 400, 250);
        pasPlane.fly("B", 2500);

        CargoPlane cargoPlane = new CargoPlane(900, 300_000, 500, 20000);
        cargoPlane.fly("B", 7500);
    }
}
