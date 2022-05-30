package generalCollectionTasks.task5;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class Shop {
    private static final int MAX_PERSON = 100;
    private static final int MIN_TIME_FOR_NEW_CUSTOMER = 3;
    private static final int MAX_TIME_FOR_NEW_CUSTOMER = 7;
    private static final double TIME_FOR_SELL_ONE_PRODUCT = 0.4;



    private Queue<Person> shopQueue;
    private Random random = new Random();

    int age = random.nextInt(10, 66);
    int countProduct = random.nextInt(5, 30);
    int minute = 0;             //время
    int timeNextClient = 0;     //время до нового клиента
    int numberOfClient = 1;     //номер клиента

    public Shop() {
        Comparator<Person> comparatorForShop = (person1, person2) -> {
            if (person1.getAge() >= 50 && person2.getAge() >= 50) {
                return 0;
            }
            if (person1.getAge() >= 50 && person2.getAge() <= 16) {
                return 0;
            }
            if (person2.getAge() >= 50) {
                return 1;
            }
            if (person2.getAge() <= 16) {
                return 1;
            }
            return -1;
        };
        shopQueue = new PriorityQueue<>(comparatorForShop);
        addFirst();



    }

    private void addFirst(){
        int age = random.nextInt(10, 66);
        int countProduct = random.nextInt(5, 30);
        shopQueue.offer(new Person(age, countProduct, numberOfClient));
        timeNextClient = random.nextInt(MIN_TIME_FOR_NEW_CUSTOMER, MAX_TIME_FOR_NEW_CUSTOMER);
    }

    private boolean isEnd(){
        return numberOfClient == 100;
    }
}
