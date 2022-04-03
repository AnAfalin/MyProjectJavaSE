package abstraction.part2.task2;

public class SpaceShip implements SpaceShipControls {
    private int speed;
    private int angle;

    public SpaceShip(int speed, int angle) {
        this.speed = speed;
        this.angle = angle;
    }

    @Override
    public void speedUp() {
        speed++;
    }

    @Override
    public void speedDown() {
        speed--;
    }

    @Override
    public void changeAngle(int angle) {
        this.angle = angle;
    }
}
