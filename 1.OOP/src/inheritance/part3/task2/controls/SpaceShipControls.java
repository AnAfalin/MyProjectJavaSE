package inheritance.part3.task2.controls;

public class SpaceShipControls {
    private int speed;
    private int angle;

    protected void speedUp(){
        speed++;
    }

    protected void speedDown(){
        speed--;
    }

    protected void changeAngle(int angle){
        this.angle = angle;
    }
}
