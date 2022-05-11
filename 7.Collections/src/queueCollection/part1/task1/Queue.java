package queueCollection.part1.task1;

/*
Односторонняя очередь
 */

import javax.management.ObjectName;
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
        head++;
        Object[] newArray = new Object[capacity];
        System.arraycopy(array, head, newArray, 0, tail);
        array = newArray;
        return (E) array[head];
    }

    private void isNullElement(E element){
        if(element == null){
            throw new NullPointerException("Element is null");
        }
    }

    @Override
    public String toString() {
        String strQueue = "";
        for (int i = 0; i < array.length; i++) {
            if(array[i] != null) {
                strQueue += array[i] + " ";
            }
        }
        return strQueue;
    }
}
