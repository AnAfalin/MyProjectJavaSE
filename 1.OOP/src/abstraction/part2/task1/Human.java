package abstraction.part2.task1;

public class Human implements Moveable, Jumpable{
    private double speed;

    public Human(double speed) {
        this.speed = speed;
    }

    public Human() {
        this.speed = SPEED;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public void go() {
        System.out.println("Человек идет со скоростью " + speed);
    }

    @Override
    public void jump() {
        System.out.println("Человек совершил прыжок в высоту");
    }
}
