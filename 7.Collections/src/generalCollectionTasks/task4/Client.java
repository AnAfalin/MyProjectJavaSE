package generalCollectionTasks.task4;

public class Client {
    private int number;
    private int timeArrive;
    private int timeAway;
    private int timeWaiting;

    public Client(int number, int timeArrive) {
        this.number = number;
        this.timeArrive = timeArrive;
    }

    public int getTimeWaiting() {
        return timeAway - timeArrive;
    }

    public void setTimeAway(int timeAway) {
        this.timeAway = timeAway;
    }

    public int getNumber() {
        return number;
    }

    public void away(int timeArrive){
        this.timeArrive = timeArrive;
    }
}
