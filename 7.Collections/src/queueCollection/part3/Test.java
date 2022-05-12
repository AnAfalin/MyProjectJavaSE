package queueCollection.part3;

public class Test {
    public static void main(String[] args) {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque();
        arrayDeque.addFirst(0);
        arrayDeque.addFirst(2);

        arrayDeque.addLast(1);
        arrayDeque.addLast(3);

        arrayDeque.addFirst(4);
        arrayDeque.addFirst(6);

        arrayDeque.addLast(5);

        System.out.println(arrayDeque);

        System.out.println(arrayDeque.peekFirst());
        System.out.println(arrayDeque.peekLast());

        System.out.println(arrayDeque);

        arrayDeque.pollFirst();
        arrayDeque.pollLast();

        System.out.println(arrayDeque);

        arrayDeque.addFirst(66);
        arrayDeque.addLast(55);

        System.out.println(arrayDeque);

        arrayDeque.clean();
        System.out.println(arrayDeque);

        arrayDeque.addFirst(10);
        arrayDeque.addLast(100);
        System.out.println(arrayDeque);
    }
}
