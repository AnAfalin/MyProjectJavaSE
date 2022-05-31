package generalCollectionTasks.task5;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class Shop {
    private static final int MAX_PERSON = 100;
    private static final int MIN_TIME_FOR_NEW_CUSTOMER = 1;
    private static final int MAX_TIME_FOR_NEW_CUSTOMER = 3;
    private static final int MIN_PRODUCT_IN_BASKET = 5;
    private static final int MAX_PRODUCT_IN_BASKET = 31;

    private final Queue<Customer> shopQueue;
    private final Random random = new Random();

    private Customer currentCustomer;

    private int minute = 0;             //время
    private int timeNextClient = 0;     //время до нового клиента
    private int numberOfClient = 1;     //номер клиента

    private int countChildren;
    private float timeServiceChildren;
    private int countRetiree;
    private float timeServiceRetiree;
    private int countOtherCustomer;
    private float timeServiceOtherCustomer;

    public Shop() {
        shopQueue = new PriorityQueue<>((customer1, customer2) -> {
            if (customer1.getAge() >= 50 && customer2.getAge() >= 50) {
                return 0;
            }
            if (customer1.getAge() >= 50 && customer2.getAge() <= 16) {
                return 0;
            }
            if (customer2.getAge() >= 50) {
                return 1;
            }
            if (customer2.getAge() <= 16) {
                return 1;
            }
            return -1;
        });
    }

    public void start(){
        process();
        info();
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
        shopQueue.offer(new Customer(age, countProduct, numberOfClient));
        timeNextClient = random.nextInt(MIN_TIME_FOR_NEW_CUSTOMER, MAX_TIME_FOR_NEW_CUSTOMER);
        currentCustomer = shopQueue.poll();
        numberOfClient++;
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
        if(age >= 50){
            countRetiree++;
            timeServiceRetiree = timeServiceRetiree + (float)(countProduct / 5);
        }else if(age <=16){
            countChildren++;
            timeServiceChildren = timeServiceChildren + (float)(countProduct / 5);
        }else {
            countOtherCustomer++;
            timeServiceOtherCustomer = timeServiceOtherCustomer + (float)(countProduct / 5);
        }

        shopQueue.offer(new Customer(age, countProduct, numberOfClient));
        timeNextClient = random.nextInt(MIN_TIME_FOR_NEW_CUSTOMER, MAX_TIME_FOR_NEW_CUSTOMER);
        System.out.println("В магазин пришел покупатель №" + numberOfClient + " возраст " + age + " количество товаров " + countProduct);
    }

    private boolean isEnd() {
        return numberOfClient == MAX_PERSON + 1 && shopQueue.size() == 0 && currentCustomer == null;
    }

    private void info(){

        System.out.print("Кат. покупателей\t" + "Кол-во\t" + "Среднее время обсуживания на кассе");
        System.out.printf("\nДети\t\t\t\t%d\t\t%.3f сек", countChildren, (countChildren / timeServiceChildren));
        System.out.printf("\nПенсионеры\t\t\t%d\t\t%.3f сек", countRetiree, (countRetiree / timeServiceRetiree));
        System.out.printf("\nОстальные пок.\t\t%d\t\t%.3f сек", countOtherCustomer, (countOtherCustomer / timeServiceOtherCustomer));

    }
}