package enumeration.task1;

public class Plane {
    private String title;
    private int speed;
    private TrafficStatus trafficStatus;

    public Plane(String title, int speed) {
        this.title = title;
        this.speed = speed;
        this.trafficStatus = TrafficStatus.PARKING;
    }

    public TrafficStatus getTrafficStatus() {
        return trafficStatus;
    }

    public void setTrafficStatus(TrafficStatus trafficStatus) {
        this.trafficStatus = trafficStatus;
    }
}
