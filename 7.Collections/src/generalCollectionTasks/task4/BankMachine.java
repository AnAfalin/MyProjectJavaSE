package generalCollectionTasks.task4;

import java.util.LinkedList;
import java.util.Queue;

public class BankMachine {
    private Queue<Client> bankMachine = new LinkedList<>(); //очередь банкомата
    public int timeServiceInQueue; //время обслуживания у банкомата

    public void awayClient(){
        System.out.println("Завершено обслуживание клиента №" + bankMachine.peek().getNumber());
        bankMachine.poll();
    }

    public int timeWaiting(){
        System.out.println("Клиент обслуживался " + bankMachine.peek().getTimeWaiting());
        return bankMachine.peek().getTimeWaiting();
    }

    public void arriveClient(int numberOfClients, int timeArrive){
        bankMachine.offer(new Client(numberOfClients, timeArrive));
    }

    public int sizeQueue(){
        return bankMachine.size();
    }

    public void startServiceNewClient(int timeStart){
        bankMachine.peek().setStartTimeService(timeStart);
    }

}
