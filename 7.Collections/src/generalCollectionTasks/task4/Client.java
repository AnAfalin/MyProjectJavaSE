package generalCollectionTasks.task4;

public class Client {
    private int number;
    private int timeArrive;
    private int startTimeService;

    public Client(int number, int timeArrive) {
        this.number = number;
        this.timeArrive = timeArrive;
    }

    public int getTimeWaiting() {
        return startTimeService - timeArrive;
    }

    public void setStartTimeService(int startTimeService) {
        this.startTimeService = startTimeService;
    }

    public int getNumber() {
        return number;
    }
}