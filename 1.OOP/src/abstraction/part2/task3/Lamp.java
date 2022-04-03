package abstraction.part2.task3;

public class Lamp implements Condition{

    @Override
    public void on() {
        System.out.println("Lamp is on");;
    }

    @Override
    public void off() {
        System.out.println("Lamp is off");
    }
}
