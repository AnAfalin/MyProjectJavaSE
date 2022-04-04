package queue;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Queue<T> {
    Object arr[];
    int capacity;

    int tail;
    int head;

    public Queue() {
        capacity = 10;
        arr = new Object[capacity];
    }
    public void offer(T element) {
        if(tail + 1 >= capacity) {
            capacity *= 2;
            Object[] newArray = Arrays.copyOf(arr, capacity, arr.getClass());
            arr = newArray;
        }
        arr[tail++] = element;
    }

    public T poll() {
        if(isEmpty()){
            return null;
        }
        Object element = arr[head];
        Object[] newArray = new Object[capacity];
        System.arraycopy(arr, head++, newArray, 0, tail);
        arr = newArray;
        return (T)element;
    }

    public T remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        Object element = arr[head];
        Object[] newArray = new Object[capacity];
        System.arraycopy(arr, head++, newArray, 0, tail);
        arr = newArray;
        return (T)element;
    }

    public T peek(){
        if(isEmpty()) {
            return null;
        }
        return (T)arr[head];
    }
    private boolean isEmpty() {
        return tail == head;
    }


    public void print() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue();
        queue.offer(5);
     //   queue.offer(6);
      //  queue.offer(7);
        queue.print();
        System.out.println(queue.poll());
        System.out.println(queue.remove());
        queue.print();

    }


}