package queueCollection.part1.task4;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {

        Comparator<Person> comparator = new Comparator<>() {
            @Override
            public int compare(Person p1, Person p2) {
                return Integer.compare(p1.getName().length() + p1.getSurname().length(), p2.getName().length() + p2.getSurname().length());
            }
        };

        Queue<Person> queue = new PriorityQueue<>(comparator);

        queue.add(new Person("Сара", "Зайцева"));
        queue.add(new Person("Илья", "Ильюшин"));
        queue.add(new Person("Як", "Самойлов"));
        queue.add(new Person("Як", "Кот"));
        queue.add(new Person("Илья", "Иванов"));
        queue.add(new Person("Ярослав", "Сидоренко"));

        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }

    }
}
