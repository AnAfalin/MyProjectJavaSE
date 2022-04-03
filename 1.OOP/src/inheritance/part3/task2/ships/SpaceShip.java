package inheritance.part3.task2.ships;

import oop.inheritance.part3.task2.controls.SpaceShipControls;

public class SpaceShip extends SpaceShipControls {
    @Override
    public void speedUp() {
        super.speedUp();
    }

    @Override
    public void speedDown() {
        super.speedDown();
    }

    @Override
    public void changeAngle(int angle) {
        super.changeAngle(angle);
    }
}
