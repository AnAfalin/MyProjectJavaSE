package enumeration.task1;

public class Plane {
    private String title;
    private int speed;
    private TrafficStatus trafficStatus = TrafficStatus.PARKING;

    public Plane(String title, int speed) {
        this.title = title;
        this.speed = speed;
    }

    public TrafficStatus getTrafficStatus() {
        return trafficStatus;
    }

    public void setTrafficStatus(TrafficStatus trafficStatus) {
        this.trafficStatus = trafficStatus;
    }
}
