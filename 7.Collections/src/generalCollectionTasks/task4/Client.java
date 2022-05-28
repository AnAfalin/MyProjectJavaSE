package generalCollectionTasks.task4;

public class Client {
    private int number;
    private int timeArrive;
    private int timeAway;
    private int timeWaiting;

    public Client(int number) {
        this.number = number;
    }

    public int getTimeWaiting() {
        return timeAway - timeArrive;
    }


}
