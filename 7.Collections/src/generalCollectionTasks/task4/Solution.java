package generalCollectionTasks.task4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Solution {
    Random random = new Random();

    Queue<Integer> bankMachine1 = new LinkedList<>(); //очередь первого банкомата
    Queue<Integer> bankMachine2 = new LinkedList<>(); //очередь второго банкомата

    public static final int MIN_MINUTES_FOR_NEW_CLIENT = 1;
    public static final int MAX_MINUTES_FOR_NEW_CLIENT = 2;

    public static final int MIN_MINUTES_FOR_SERVICE_CLIENT = 5;
    public static final int MAX_MINUTES_FOR_SERVICE_CLIENT = 7;

    int minutes = 0; //время

    int countAway = 0;      //количество ушедших
    int countService = 0;   //количество обслуженных
    int countWaiting = 0;

    int timeService = 0;

    int timeServiceInQueue1 = 0; //врем обслуживания у банкомата 1
    int timeServiceInQueue2 = 0; //врем обслуживания у банкомата 2
    int timeWaiting = 0; //время ожидания
    int timeNextClient;  //через сколько придет новый клиент

    int numberOfClients;    //номер клиента max = 100

    public Solution() {
        addFirst();
        process();
        System.out.println("Было обслужено " + countService + " человек");
        System.out.println("Ушло " + countAway + " человек");
        System.out.println("Общее время обслуживания " + timeService);
        System.out.println("Среднее время обслуживания " + timeService / countService);
        System.out.println("Среднее время ожидания " + timeWaiting / countService);
    }

    public void process() {
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
                    System.out.println("Банкомат №1 обслужил клента № " + bankMachine1.poll());
                    countService++;
                    timeServiceInQueue1 = random.nextInt(MIN_MINUTES_FOR_SERVICE_CLIENT, MAX_MINUTES_FOR_SERVICE_CLIENT);
                    timeService += timeServiceInQueue1;
                } else if (timeServiceInQueue2 == 0 && bankMachine2.size() != 0) {
                    System.out.println("Банкомат №2 обслужил клента № " + bankMachine2.poll());
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
            timeWaiting += (bankMachine1.size() - 1 + bankMachine2.size() - 1);
            countWaiting += (bankMachine1.size() - 1 + bankMachine2.size() - 1);
            System.out.println("timeWaiting" + timeWaiting);
            System.out.println("Очередь в первый банкомат ------------" + bankMachine1.size());
            System.out.println("Очередь во второй банкомат ------------" + bankMachine2.size());
            minutes++;
        }
    }

    public void addFirst() {
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

    public boolean isEnd() {
        return numberOfClients == 100 && bankMachine1.size() == 0 && bankMachine2.size() == 0;
    }

    private int newClient() {
        if (bankMachine1.size() < bankMachine2.size()) {
            if (bankMachine1.size() < 8) {
                System.out.println("К банкомату №1 пришел клиент №" + numberOfClients);
                bankMachine1.offer(numberOfClients);
                return 1;
            }
        } else if (bankMachine1.size() > bankMachine2.size()) {
            if (bankMachine2.size() < 8) {
                System.out.println("К банкомату №2 пришел клиент №" + numberOfClients);
                bankMachine2.offer(numberOfClients);
                return 2;
            }
        } else {
            int randomQueue = random.nextInt(1, 3);
            if (randomQueue == 1 && bankMachine1.size() < 8) {
                System.out.println("К банкомату №1 пришел клиент №" + numberOfClients);
                bankMachine1.offer(numberOfClients);
                return 1;
            } else if (randomQueue == 2 && bankMachine2.size() < 8) {
                System.out.println("К банкомату №2 пришел клиент №" + numberOfClients);
                bankMachine2.offer(numberOfClients);
                return 2;
            } else {
                System.out.println("К банкомату пришел клиент №" + numberOfClients + " но очередь больше 8 человек и клиент ушел");
                countAway++;

            }
        }
        return 0;
    }


}

class Main {
    public static void main(String[] args) {
        new Solution();
    }
}
