package inheritance.part3.task5;

public class Main {
    public static void main(String[] args) {
        Train train = new Train();
        train.drive(3000);
        Car car = new Car();
        car.drive(400);
        Moto moto = new Moto();
        moto.drive(100);

        System.out.println(Transport.getCount());

    }
}
