package queueCollection.part1.task1;

/*
Односторонняя очередь
 */

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Queue<E> {
    private Object array[];
    private int capacity;

    private int head; //голова
    private int tail; //хвост

    public Queue() {
        capacity = 10;
        array = new Object[capacity];
    }

    //метод добавляет элемент в конец очереди.
    //Если элемент удачно добавлен, возвращает true
    //Если элемент равен null - бросается исключение NullPointerException
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

    //метод возвращает элемент из начала очереди с удалением этого элемента.
    //Если очередь пуста, возвращает значение null
    @SuppressWarnings("unchecked")
    public E poll(){
        if(isEmptyQueue()){
            return null;
        }
        E element = (E)array[head];
        head++;
        return element;
    }

    //метод возвращает элемент из начала очереди с удалением этого элемента.
    //Если очередь пуста, генерирует исключение NoSuchElementException
    // @SuppressWarnings("unchecked")
    public E remove(){
        isEmptyQueueException();
        E element = (E)array[head];
        head++;
        Object[] newArray = new Object[capacity];
        System.arraycopy(array, head, newArray, 0, tail);
        array = newArray;
        head--;
        return element;
    }

    //метод возвращает, но не удаляет, элемент из начала очереди.
    //Если очередь пуста, генерирует исключение NoSuchElementException
    @SuppressWarnings("unchecked")
    public E element(){
        isEmptyQueueException();
        return (E)array[head];
    }

    //метод возвращает элемент из начала очереди без удаления этого элемента.
    //Если очередь пуста, возвращает значение null
    @SuppressWarnings("unchecked")
    public E peek(){
        if(isEmptyQueue()){
            return null;
        }
        return (E)array[head];
    }

    //метод проверки элемента на значение null
    private void isNullElement(E element){
        if(element == null){
            throw new NullPointerException("Element is null");
        }
    }

    //метод проверки очереди на непустоту
    private boolean isEmptyQueue(){
        return tail == head;
    }

    //метод проверки очереди на непустоту с генерацией исключения
    private void isEmptyQueueException(){
        if(tail == head){
            throw new NoSuchElementException("Queue is empty");
        }
    }

    @Override
    public String toString() {
        StringBuilder strQueue = new StringBuilder();
        for (Object o : array) {
            if (o != null) {
                strQueue.append(o).append(" ");
            }
        }
        return strQueue.toString();
    }
}
