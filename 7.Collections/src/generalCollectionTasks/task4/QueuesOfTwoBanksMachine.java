package generalCollectionTasks.task4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class QueuesOfTwoBanksMachine {
    private  static final int MIN_MINUTES_FOR_NEW_CLIENT = 1;
    private  static final int MAX_MINUTES_FOR_NEW_CLIENT = 6 ;

    private  static final int MIN_MINUTES_FOR_SERVICE_CLIENT = 3;
    private  static final int MAX_MINUTES_FOR_SERVICE_CLIENT = 7;

    private Random random = new Random();

    private Queue<Client> bankMachine1 = new LinkedList<>(); //очередь первого банкомата
    private Queue<Client> bankMachine2 = new LinkedList<>(); //очередь второго банкомата

    private int minutes = 0; //время

    private int countAway = 0;      //количество ушедших
    private int countService = 0;   //количество обслуженных

    private int timeService = 0;
    private int timeServiceInQueue1 = 0; //время обслуживания у банкомата 1
    private int timeServiceInQueue2 = 0; //время обслуживания у банкомата 2
    private int timeWaiting = 0; //время ожидания
    private int timeNextClient;  //через сколько придет новый клиент

    private int numberOfClients; //номер клиента max = 100

    public QueuesOfTwoBanksMachine() {
        addFirst();
        process();
        info();
    }

    private void process() {
        while (!isEnd()) {
            System.out.println("минута ..." + minutes);
            //если время до нового клиента осталось 0 минут то он приходит
            if (timeNextClient == 0 && numberOfClients < 100) {
                newClient();
                timeNextClient = random.nextInt(MIN_MINUTES_FOR_NEW_CLIENT, MAX_MINUTES_FOR_NEW_CLIENT);
                numberOfClients++;
            } else {
                timeNextClient--;
            }

            //уменьшение времени обсулживания у банкоматов или завершения обслуживания у банкомата
            if (bankMachine1.size() != 0 || bankMachine2.size() != 0) {
                if (timeServiceInQueue1 == 0 && bankMachine1.size() != 0) {

                    bankMachine1.peek().setTimeAway(minutes);
                    timeWaiting += bankMachine1.peek().getTimeWaiting();


                    System.out.println("Банкомат №1 обслужил клента № " + bankMachine1.poll().getNumber());
                    countService++;
                    timeServiceInQueue1 = random.nextInt(MIN_MINUTES_FOR_SERVICE_CLIENT, MAX_MINUTES_FOR_SERVICE_CLIENT);
                    timeService += timeServiceInQueue1;
                } else if (timeServiceInQueue2 == 0 && bankMachine2.size() != 0) {
                    bankMachine2.peek().setTimeAway(minutes);
                    timeWaiting += bankMachine2.peek().getTimeWaiting();
                    System.out.println("Банкомат №2 обслужил клента № " + bankMachine2.poll().getNumber());
                    countService++;
                    timeServiceInQueue2 = random.nextInt(MIN_MINUTES_FOR_SERVICE_CLIENT, MAX_MINUTES_FOR_SERVICE_CLIENT);
                    timeService += timeServiceInQueue2;
                } else {
                    if (timeServiceInQueue1 > 0) {
                        timeServiceInQueue1--;
                    }
                    if (timeServiceInQueue2 > 0) {
                        timeServiceInQueue2--;
                    }
                }
            }
            minutes++;
        }
    }

    private void addFirst() {
        numberOfClients = 1;
        int firstClient = newClient();
        int timeServiceFirstClient = random.nextInt(MIN_MINUTES_FOR_NEW_CLIENT, MAX_MINUTES_FOR_NEW_CLIENT);
        timeService += timeServiceFirstClient;
        if (firstClient == 1) {
            timeServiceInQueue1 = timeServiceFirstClient;
        } else if (firstClient == 2) {
            timeServiceInQueue2 = timeServiceFirstClient;
        }
        timeNextClient = random.nextInt(1, 7);
    }

    private boolean isEnd() {
        return numberOfClients == 100 && bankMachine1.size() == 0 && bankMachine2.size() == 0;
    }

    private int newClient() {
        if (bankMachine1.size() < bankMachine2.size()) {
            if (bankMachine1.size() < 8) {
                System.out.println("К банкомату №1 пришел клиент №" + numberOfClients);
                bankMachine1.offer(new Client(numberOfClients, minutes));
                return 1;
            }
        } else if (bankMachine1.size() > bankMachine2.size()) {
            if (bankMachine2.size() < 8) {
                System.out.println("К банкомату №2 пришел клиент №" + numberOfClients);
                bankMachine2.offer(new Client(numberOfClients, minutes));
                return 2;
            }
        } else {
            int randomQueue = random.nextInt(1, 3);
            if (randomQueue == 1 && bankMachine1.size() < 8) {
                System.out.println("К банкомату №1 пришел клиент №" + numberOfClients);
                bankMachine1.offer(new Client(numberOfClients, minutes));
                return 1;
            } else if (randomQueue == 2 && bankMachine2.size() < 8) {
                System.out.println("К банкомату №2 пришел клиент №" + numberOfClients);
                bankMachine2.offer(new Client(numberOfClients, minutes));
                return 2;
            } else {
                System.out.println("К банкомату пришел клиент №" + numberOfClients + " но очередь больше 8 человек и клиент ушел");
                countAway++;

            }
        }
        return 0;
    }

    private void info(){
        System.out.println("Было обслужено " + countService + " человек");
        System.out.println("Ушло " + countAway + " человек");
        System.out.println("Среднее время обслуживания " + timeService / countService + " минут");
        System.out.println("Среднее время ожидания " + timeWaiting / countService + " минут");
    }

}
