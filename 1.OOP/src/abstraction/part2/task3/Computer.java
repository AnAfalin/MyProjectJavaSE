package abstraction.part2.task3;

public class Computer implements Condition{

    @Override
    public void on() {
        System.out.println("Computer is on and ready to work");;
    }

    @Override
    public void off() {
        System.out.println("Computer is off. The work is over");;
    }
}
