package queueCollection.part2.task3;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class Solution {
    public static void main(String[] args) {

        Queue<Integer> queue1 = new PriorityQueue<>();
        Queue<Integer> queue2 = new PriorityQueue<>();


        for(int i = 1; i <=100; i++) {
            if(queue1.size() < queue2.size()){
                queue1.offer(i);
            }else if(queue1.size() > queue2.size()){
                queue2.offer(i);
            }else {
                int r = (int)(Math.random() * 2 + 1);
                if(r == 1){
                    queue1.offer(i);
                }else {
                    queue2.offer(i);
                }
            }

            System.out.println(queue1);
            System.out.println(queue2);

            int x = (int)(Math.random() * 11);
            if(x >= 5){
                System.out.println("Один из банкоматов обслужил клиента");
                int r = (int)(Math.random() * 2 + 1);
                if(r == 1 && !queue1.isEmpty()){
                    queue1.remove();
                }else if(r == 2 && !queue2.isEmpty()){
                    queue2.remove();
                }
                System.out.println(queue1);
                System.out.println(queue2);
            }

            System.out.println();
        }
    }
}
