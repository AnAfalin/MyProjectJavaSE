package generalCollectionTasks.task4;

public class Client {
    private final int number;
    private final int timeArrive;
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
