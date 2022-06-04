package generalCollectionTasks.task4;

import java.util.*;

public class BanksMachine {
    private final QueueBankMachine bankMachine1 = new QueueBankMachine();
    private final QueueBankMachine bankMachine2 = new QueueBankMachine();

    private static final int MIN_MINUTES_FOR_NEW_CLIENT = 1;
    private static final int MAX_MINUTES_FOR_NEW_CLIENT = 3;

    private static final int MIN_MINUTES_FOR_SERVICE_CLIENT = 3;
    private static final int MAX_MINUTES_FOR_SERVICE_CLIENT = 7;

    private static final int MAX_PEOPLE_IN_QUEUE = 8;

    private static final int MAX_PEOPLE_FOR_SERVICE = 100;

    private Random random = new Random();

    private int timeNextClient;     //через сколько придет новый клиент
    private int numberOfClients = 1;    //номер клиента max = 100
    private int minutes = 0;                //время
    private int countAwayClients = 0;      //количество ушедших

    static class QueueBankMachine {
        private final Queue<Client> bankMachine = new LinkedList<>(); //очередь банкомата
        public int currentTimeServiceInQueue;  //текущее время обслуживания у банкомата
        public int timeServiceInQueue;  //текущее время обслуживания у банкомата
        public int timeWaitingInQueue;  //время ожидания в очереди к банкомату
        public int countClientService;  //количество обслуженных
        public int countWaitClient;     //количество человек, которые ждали обслуживания

        public void awayClient(){
            timeWaitingInQueue += timeWaiting();
            bankMachine.poll();
        }

        public int timeWaiting(){
            if(bankMachine.peek() != null) {
                return bankMachine.peek().getTimeWaiting();
            }
            return 0;
        }

        public void arriveClient(int numberOfClients, int timeArrive){
            bankMachine.offer(new Client(numberOfClients, timeArrive));
        }

        public int sizeQueue(){
            return bankMachine.size();
        }

        public void startServiceNewClient(int timeStart){
            if(bankMachine.peek() != null) {
                bankMachine.peek().setStartTimeService(timeStart);
            }
        }

        public Client getFirst(){
            if(bankMachine.peek() != null) {
                return bankMachine.peek();
            }
            else return null;
        }

    }

    public void start(){
        process();
        info();
    }

    private void process() {
        while (!isEnd()) {
            arriveClients();
            service();
            minutes++;
        }
    }

    private void arriveClients() {
        //если время до нового клиента осталось 0 минут то он приходит
        if (timeNextClient == 0 && numberOfClients <= MAX_PEOPLE_FOR_SERVICE) {
            newClient();
            timeNextClient = random.nextInt(MIN_MINUTES_FOR_NEW_CLIENT, MAX_MINUTES_FOR_NEW_CLIENT);
            numberOfClients++;
        }

        if (timeNextClient != 0) {
            timeNextClient--;
        }
    }

    private void service() {
        //уменьшение времени обслуживания у банкоматов или завершения обслуживания у банкомата
        if (bankMachine1.currentTimeServiceInQueue == 0 && bankMachine1.sizeQueue() != 0) {
            bankMachine1.awayClient();
            bankMachine1.countClientService++;

            if (bankMachine1.sizeQueue() != 0) {
                bankMachine1.startServiceNewClient(minutes + 1);
                bankMachine1.countWaitClient++;
            }

            bankMachine1.currentTimeServiceInQueue = random.nextInt(MIN_MINUTES_FOR_SERVICE_CLIENT, MAX_MINUTES_FOR_SERVICE_CLIENT);
            bankMachine1.timeServiceInQueue += bankMachine1.currentTimeServiceInQueue;
        }

        if (bankMachine2.currentTimeServiceInQueue == 0 && bankMachine2.sizeQueue() != 0) {
            System.out.println("Банкомат №2 обсужил клиента №" + bankMachine2.getFirst().getNumber());
            bankMachine2.awayClient();
            bankMachine2.countClientService++;

            if (bankMachine2.sizeQueue() != 0) {
                bankMachine2.startServiceNewClient(minutes + 1);
                bankMachine2.countWaitClient++;
            }

            bankMachine2.currentTimeServiceInQueue = random.nextInt(MIN_MINUTES_FOR_SERVICE_CLIENT, MAX_MINUTES_FOR_SERVICE_CLIENT);
            bankMachine2.timeServiceInQueue += bankMachine1.currentTimeServiceInQueue;
        }

        if (bankMachine1.currentTimeServiceInQueue > 0) {
            bankMachine1.currentTimeServiceInQueue--;
        }
        if (bankMachine2.currentTimeServiceInQueue > 0) {
            bankMachine2.currentTimeServiceInQueue--;
        }
    }

    private boolean isEnd() {
        return numberOfClients == MAX_PEOPLE_FOR_SERVICE + 1 && bankMachine1.sizeQueue() == 0 && bankMachine2.sizeQueue() == 0;
    }

    private void newClient() {
        if(bankMachine1.sizeQueue() < bankMachine2.sizeQueue()) {
            if (bankMachine1.sizeQueue() < MAX_PEOPLE_IN_QUEUE) {
                bankMachine1.arriveClient(numberOfClients, minutes);
            } else {
                countAwayClients++;
            }
            return;
        }
        if(bankMachine1.sizeQueue() > bankMachine2.sizeQueue()) {
            if (bankMachine2.sizeQueue() < MAX_PEOPLE_IN_QUEUE) {
                bankMachine2.arriveClient(numberOfClients, minutes);
            } else {
                countAwayClients++;
            }
            return;
        }
        int randomQueue = random.nextInt(1,3);
        if (randomQueue == 1) {
            bankMachine1.arriveClient(numberOfClients, minutes);
            return;
        }
        bankMachine2.arriveClient(numberOfClients, minutes);
    }

    private void info() {
        int allClientService = bankMachine1.countClientService + bankMachine2.countClientService;
        int averageTimeService = (bankMachine1.timeServiceInQueue + bankMachine2.timeServiceInQueue) / (bankMachine1.countClientService + bankMachine2.countClientService);
        int averageTimeWaiting = (bankMachine1.timeWaitingInQueue + bankMachine2.timeWaitingInQueue) / (bankMachine1.countWaitClient + bankMachine2.countWaitClient);
        System.out.println("<<Информация>>");
        System.out.println("Было обслужено " + allClientService + " человек");
        System.out.println("Ушло " + countAwayClients + " человек");
        System.out.println("Среднее время обслуживания " + averageTimeService + " минут");
        System.out.println("Среднее время ожидания " + averageTimeWaiting  + " минут");
    }

}
