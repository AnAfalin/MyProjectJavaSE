package queueCollection.part1.task1;


public class Test {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();

        //проверка генерации ошибки при удалении элемента из пустой очереди
        //queue.remove();

        //проверка генерации ошибки при возвращении первого элемента из пустой очереди
        //queue.element();

        //проверка возвращения значения null из пустой очереди
        System.out.println(queue.peek());

        queue.offer(5);
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);

        System.out.println(queue);

        System.out.println("First element out " + queue.poll());
        System.out.println(queue);

        System.out.println("First element print, but doesn't out " + queue.element());
        System.out.println(queue);

        System.out.println("Add element in tail queue");
        queue.offer(50);
        System.out.println(queue);
        queue.poll();
        queue.poll();
        System.out.println(queue);

    }

}
