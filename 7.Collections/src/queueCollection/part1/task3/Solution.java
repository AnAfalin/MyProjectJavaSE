package queueCollection.part1.task3;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {

        Comparator<Person> comparator = new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                if(p1.getName().compareTo(p2.getName()) == 0) {
                    return p1.getSurname().compareTo(p2.getSurname());
                }
                return p1.getName().compareTo(p2.getName());
            }
        };

        Queue<Person> queue = new PriorityQueue<>();
        //Queue<Person> queue = new PriorityQueue<>(comparator);

        queue.add(new Person("Сара", "Зайцева"));
        queue.add(new Person("Илья", "Ильюшин"));
        queue.add(new Person("Илья", "Иванов"));
        queue.add(new Person("Як", "Самойлов"));
        queue.add(new Person("Ярослав", "Сидоренко"));

        System.out.println(queue);

    }
}
