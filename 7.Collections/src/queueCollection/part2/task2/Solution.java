package queueCollection.part2.task2;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        Comparator<Person> comparator = new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                if(p1.getAge() >= 60 && p2.getAge() >= 60){
                    return 0;
                }else if(p2.getAge() >= 60){
                    return 1;
                }else if(p1.getAge() >=60) {
                    return -1;
                }else return 0;
            }
        };
        Queue<Person> queueInShop = new PriorityQueue<>(comparator);
        queueInShop.offer(new Person("Сергей", 60));
        queueInShop.offer(new Person("Алексей", 55));
        queueInShop.offer(new Person("Иван", 20));
        queueInShop.offer(new Person("Петр", 25));
        queueInShop.offer(new Person("Иван", 70));
        queueInShop.offer(new Person("Светлана", 40));
        queueInShop.offer(new Person("Вера", 65));

        System.out.println(queueInShop);

        while (!queueInShop.isEmpty()){
            System.out.println(queueInShop.poll());
        }
    }
}
