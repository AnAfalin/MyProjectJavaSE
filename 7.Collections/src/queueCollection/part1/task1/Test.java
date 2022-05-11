package queueCollection.part1.task1;


public class Test {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.offer(5);
        queue.offer(10);
        queue.offer(15);
        queue.offer(20);

        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);


    }

}
