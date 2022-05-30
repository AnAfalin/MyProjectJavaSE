package generalCollectionTasks.task5;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class Shop {
    private static final int MAX_PERSON = 100;
    private static final int MIN_TIME_FOR_NEW_CUSTOMER = 3;
    private static final int MAX_TIME_FOR_NEW_CUSTOMER = 5;
    private static final int MIN_PRODUCT_IN_BASKET = 5;
    private static final int MAX_PRODUCT_IN_BASKET = 31;

    private final Queue<Person> shopQueue;
    private Person currentCustomer;
    private Random random = new Random();

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
        process();

    }

    private void process() {

        addFirst();

        while (!isEnd()) {
            System.out.println(minute);
            System.out.println(currentCustomer);
            System.out.println(shopQueue);

            arriveClient();
            service();
            minute++;
        }
    }

    private void service() {
        if (currentCustomer == null && shopQueue.size() != 0) {
            currentCustomer = shopQueue.poll();
        }

        if (currentCustomer != null) {
            if (currentCustomer.countProduct >= 10) {
                currentCustomer.countProduct -= 10;
            } else {
                currentCustomer.countProduct = 0;
                currentCustomer = null;
            }
        }
    }

    private void addFirst() {
        int age = random.nextInt(10, 80);
        int countProduct = random.nextInt(MIN_PRODUCT_IN_BASKET, MAX_PRODUCT_IN_BASKET);
        shopQueue.offer(new Person(age, countProduct, numberOfClient));
        timeNextClient = random.nextInt(MIN_TIME_FOR_NEW_CUSTOMER, MAX_TIME_FOR_NEW_CUSTOMER);
        currentCustomer = shopQueue.poll();
    }

    private void arriveClient() {
        if (timeNextClient == 0 && numberOfClient != MAX_PERSON + 1) {
            newClient();
            timeNextClient = random.nextInt(MIN_TIME_FOR_NEW_CUSTOMER, MAX_TIME_FOR_NEW_CUSTOMER);
            numberOfClient++;

        }
        if (timeNextClient != 0) {
            timeNextClient--;
        }
    }

    private void newClient() {
        int age = random.nextInt(10, 66);
        int countProduct = random.nextInt(5, 30);
        shopQueue.offer(new Person(age, countProduct, numberOfClient));
        timeNextClient = random.nextInt(MIN_TIME_FOR_NEW_CUSTOMER, MAX_TIME_FOR_NEW_CUSTOMER);
        System.out.println("В магазин пришел покупатель №" + numberOfClient + " возраст " + age + " количество товаров " + countProduct);
    }

    private boolean isEnd() {
        return numberOfClient == MAX_PERSON + 1 && shopQueue.size() == 0 && currentCustomer == null;
    }
}
