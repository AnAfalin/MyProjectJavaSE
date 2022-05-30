package generalCollectionTasks.task5;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        //Shop shop = new Shop();
        Comparator<Person> comparator = new Comparator<Person>() {
            @Override
            public int compare(Person person1, Person person2) {
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
            }
        };
        Queue<Person> shopQueue = new PriorityQueue<>(comparator);

        shopQueue.offer(new Person(45, 10, 1));
        shopQueue.offer(new Person(30, 10, 1));
        shopQueue.offer(new Person(60, 10, 2));
        shopQueue.offer(new Person(80, 10, 2));
        shopQueue.offer(new Person(20, 10, 2));
        shopQueue.offer(new Person(16, 10, 3));

        shopQueue.poll();
        shopQueue.poll();

        System.out.println(shopQueue);
    }
}
