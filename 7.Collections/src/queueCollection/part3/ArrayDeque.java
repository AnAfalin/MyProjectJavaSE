package queueCollection.part3;

import java.util.Arrays;

public class ArrayDeque<E> {
    private Object array[];
    private int capacity;

    private int head;
    private int tail;

    public ArrayDeque() {
        capacity = 10;
        array = new Object[capacity];
        head = 0;
        tail = 0;

    }

    public void addFirst(E element){
        if(head - 1 == tail){
            grow();
        }
        if(isEmpty()){
            head = capacity - 1;
            array[head] = element;
        }else {
            array[--head] = element;
        }
    }

    public void addLast(E element){
        if(tail - 1 == head){
            grow();
        }
        array[tail] = element;
        tail++;
    }

    private void grow(){
        capacity *= 2;
        Object[] newArray = new Object[capacity];
        for (int i = 0; i < tail; i++) {
            newArray[i] = array[i];
        }
        for (int i = 0; i <= head ; i++) {
            newArray[newArray.length - 1 - i] = array[array.length - 1 - i];
        }
        head = capacity + 1 - head;
        array = newArray;
    }

    private boolean isEmpty(){
        return head == tail;
    }

    @Override
    public String toString() {
        StringBuilder strArrayDeque = new StringBuilder();
        for (Object o : array) {
            if(o != null){
                strArrayDeque.append(o).append(" ");
            }else {
                strArrayDeque.append(".").append(" ");
            }

        }
        return strArrayDeque.toString();
    }
}
