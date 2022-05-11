package queueCollection.part1.task1;

/*
Односторонняя очередь
 */

import java.util.Arrays;

public class Queue<E> {
    private Object array[];
    private int capacity;

    private int head; //голова
    private int tail; //хвост

    public Queue() {
        capacity = 10;
        array = new Object[capacity];
    }

    //метод добавление в очередь
    public boolean offer(E element){
        isNullElement(element);
        if(tail + 1 >= capacity) {
            capacity = capacity * 2;
            Object[] newArray = Arrays.copyOf(array, capacity);
            array = newArray;
        }
        array[tail] = element;
        tail++;
        return true;
    }

    //метод удаления из очереди
    @SuppressWarnings("unchecked")
    public E poll(){
        if(isEmptyQueue()){
            return null;
        }
        E element = (E)array[head];
        head++;
        Object[] newArray = new Object[capacity];
        System.arraycopy(array, head, newArray, 0, tail);
        array = newArray;
        head--;
        return element;
    }

    private void isNullElement(E element){
        if(element == null){
            throw new NullPointerException("Element is null");
        }
    }

    private boolean isEmptyQueue(){
        return tail == head;
    }

    @Override
    public String toString() {
        String strQueue = "";
        for (Object o : array) {
            if (o != null) {
                strQueue += o + " ";
            }
        }
        return strQueue;
    }
}
