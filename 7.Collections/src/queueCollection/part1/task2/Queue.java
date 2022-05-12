package queueCollection.part1.task2;

import java.util.NoSuchElementException;

public class Queue<T> {
    private Object arr[];
    private int capacity;

    int head;
    int tail;

    public Queue() {
        capacity = 10;
        arr = new Object[capacity];
    }

    //на слайде №17 в презентации
    public void add(T element){
        if(tail + 1 >= capacity) {
            capacity *= 2;
            Object[] arr2 = new Object[capacity];
            System.arraycopy(arr, 0, arr2, 0, arr.length);
            arr = arr2;
        }
        arr[tail++] = element;
    }

    //на слайде №19 в презентации
    @SuppressWarnings("unchecked")
    public T poll() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return (T) arr[head++];
    }

    //на слайде №20 в презентации
    private boolean isEmpty(){
        if(head == tail) {
            return true;
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public T peek(){
        if(head == tail) {
            return null;
        }
        return (T)arr[head];
    }
}

/*
Ошибка:
метод poll в случает пустой очереди возвращает null, a не генерирует исключение
 */
