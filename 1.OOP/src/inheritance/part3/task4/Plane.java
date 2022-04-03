package inheritance.part3.task4;

public class Plane {
    protected int speed;
    protected int fuel;
    protected int consumptionFuel;

    public Plane(int speed, int fuel, int consumptionFuel) {
        this.speed = speed;
        this.fuel = fuel;
        this.consumptionFuel = consumptionFuel;
    }

    public  void fly(String point, int distance){
        if(distance / consumptionFuel < fuel) {
            System.out.println("Самолету хватит топлива чтобы долететь до пункта " + point + ". Время в полете будет около " + distance / speed + " часов");
        }else {
            System.out.println("Самолету не хватит топлива чтобы долететь до пункта " + point);
        }
    }
}
