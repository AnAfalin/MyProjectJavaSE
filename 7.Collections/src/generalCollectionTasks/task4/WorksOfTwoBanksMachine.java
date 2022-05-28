package generalCollectionTasks.task4;

import java.util.*;

public class WorksOfTwoBanksMachine {
    BankMachine bankMachine1 = new BankMachine();
    BankMachine bankMachine2 = new BankMachine();

    private  static final int MIN_MINUTES_FOR_NEW_CLIENT = 1;
    private  static final int MAX_MINUTES_FOR_NEW_CLIENT = 4;

    private  static final int MIN_MINUTES_FOR_SERVICE_CLIENT = 5;
    private  static final int MAX_MINUTES_FOR_SERVICE_CLIENT = 7;

    private Random random = new Random();

    private int minutes = 0; //время
    private int countAwayClients = 0;      //количество ушедших
    private int countAllClientService = 0;   //количество обслуженных
    private int timeService = 0;
    private int timeWaitingOfAllClients = 0; //время ожидания всех клиентов
    private int timeNextClient;  //через сколько придет новый клиент
    private int numberOfClients; //номер клиента max = 100

    public WorksOfTwoBanksMachine() {
        process();
        info();
    }

    private void process() {
        addFirst();

        while (!isEnd()) {
            System.out.println("минута ..." + minutes);
            arriveClients();
            service();
            minutes++;
        }
    }

    private void arriveClients(){
        //если время до нового клиента осталось 0 минут то он приходит
        if (timeNextClient == 0 && numberOfClients < 100) {
            newClient();
            timeNextClient = random.nextInt(MIN_MINUTES_FOR_NEW_CLIENT, MAX_MINUTES_FOR_NEW_CLIENT);
            numberOfClients++;
        } else {
            timeNextClient--;
        }
    }

    private void service(){
        //уменьшение времени обслуживания у банкоматов или завершения обслуживания у банкомата
        if (bankMachine1.sizeQueue() != 0 || bankMachine2.sizeQueue() != 0) {
            if (bankMachine1.timeServiceInQueue == 0 && bankMachine1.sizeQueue() != 0) {
                timeWaitingOfAllClients += bankMachine1.timeWaiting(minutes);
                System.out.print("Банкомат №1. ");
                bankMachine1.awayClient();
                countAllClientService++;
                bankMachine1.timeServiceInQueue = random.nextInt(MIN_MINUTES_FOR_SERVICE_CLIENT, MAX_MINUTES_FOR_SERVICE_CLIENT);
                timeService += bankMachine1.timeServiceInQueue;
            } else if (bankMachine2.timeServiceInQueue == 0 && bankMachine2.sizeQueue() != 0) {
                timeWaitingOfAllClients += bankMachine2.timeWaiting(minutes);
                System.out.print("Банкомат №2. ");
                bankMachine2.awayClient();
                countAllClientService++;
                bankMachine2.timeServiceInQueue = random.nextInt(MIN_MINUTES_FOR_SERVICE_CLIENT, MAX_MINUTES_FOR_SERVICE_CLIENT);
                timeService += bankMachine2.timeServiceInQueue;
            } else {
                if (bankMachine1.timeServiceInQueue > 0) {
                    bankMachine1.timeServiceInQueue--;
                }
                if (bankMachine2.timeServiceInQueue > 0) {
                    bankMachine2.timeServiceInQueue--;
                }
            }
        }
    }

    private void addFirst() {
        numberOfClients = 1;
        int firstClient = newClient();
        int timeServiceFirstClient = random.nextInt(MIN_MINUTES_FOR_NEW_CLIENT, MAX_MINUTES_FOR_NEW_CLIENT);
        timeService += timeServiceFirstClient;
        if (firstClient == 1) {
            bankMachine1.timeServiceInQueue = timeServiceFirstClient;
        } else if (firstClient == 2) {
            bankMachine2.timeServiceInQueue = timeServiceFirstClient;
        }
        timeNextClient = random.nextInt(MIN_MINUTES_FOR_NEW_CLIENT, MAX_MINUTES_FOR_NEW_CLIENT);
    }

    private boolean isEnd() {
        return numberOfClients == 100 && bankMachine1.sizeQueue() == 0 && bankMachine2.sizeQueue() == 0;
    }

    private int newClient() {
        if (bankMachine1.sizeQueue() < bankMachine2.sizeQueue()) {
            if (bankMachine1.sizeQueue() < 8) {
                System.out.println("К банкомату №1 пришел клиент №" + numberOfClients);
                bankMachine1.arriveClient(numberOfClients, minutes);
                return 1;
            }
        } else if (bankMachine1.sizeQueue() > bankMachine2.sizeQueue()) {
            if (bankMachine2.sizeQueue() < 8) {
                System.out.println("К банкомату №2 пришел клиент №" + numberOfClients);
                bankMachine2.arriveClient(numberOfClients, minutes);
                return 2;
            }
        } else {
            int randomQueue = random.nextInt(1, 3);
            if (randomQueue == 1 && bankMachine1.sizeQueue() < 8) {
                System.out.println("К банкомату №1 пришел клиент №" + numberOfClients);
                bankMachine1.arriveClient(numberOfClients, minutes);
                return 1;
            } else if (randomQueue == 2 && bankMachine2.sizeQueue() < 8) {
                System.out.println("К банкомату №2 пришел клиент №" + numberOfClients);
                bankMachine2.arriveClient(numberOfClients, minutes);
                return 2;
            } else {
                System.out.println("К банкомату пришел клиент №" + numberOfClients + " но очередь больше 8 человек и клиент ушел");
                countAwayClients++;
            }
        }
        return 0;
    }

    private void info(){
        System.out.println("Было обслужено " + countAllClientService + " человек");
        System.out.println("Ушло " + countAwayClients + " человек");
        System.out.println("Общее время обслуживания " + timeService);
        System.out.println("Среднее время обслуживания " + timeService / countAllClientService);
        System.out.println("Среднее время ожидания " + timeWaitingOfAllClients / countAllClientService);
    }

}
