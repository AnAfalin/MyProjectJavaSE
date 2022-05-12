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
    }
}
