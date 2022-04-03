package encapsulation.task2;

public class Car {
    private final String mark;
    private final String color;
    private final int maxSpeed;

    public Car(String mark, String color, int maxSpeed) {
        this.mark = mark;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    public String getMark() {
        return mark;
    }

    public String getColor() {
        return color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void driveToDestination(String point) {
        onCar();
        turnOnEngine();
        pressOnPedalGas();
        System.out.println("Машиане едет к месту назанчения " + point);
        pressOnPedalBrake();
        turnOffEngine();
        offCar();
        System.out.println("Машиане приехала к месту назанчения " + point);

    }
    private void onCar(){
        System.out.println("Машина включена");
    }
    private void turnOnEngine(){
        System.out.println("Двигатель запущен");
    }
    private void pressOnPedalGas(){
        System.out.println("Нажата педаль газа");
    }
    private void pressOnPedalBrake(){
        System.out.println("Нажата педаль тормоза");
    }
    private void offCar(){
        System.out.println("Машина выключена");
    }
    private void turnOffEngine(){
        System.out.println("Двигатель заглушен");
    }
}

