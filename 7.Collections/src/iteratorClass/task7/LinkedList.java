package iteratorClass.task7;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements Iterable<E>{
    private Node<E> first;
    public int size;

    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E element) {
            this.item = element;
        }
    }

    public void addFirst(E element) {
        Node<E> newNode = new Node<>(element);
        if (first != null) {
            newNode.next = first;
        }
        first = newNode;
        size++;
    }


    public void addLast(E element) {
        if (first == null) {
            addFirst(element);
        } else {
            Node<E> newNode = new Node<>(element);
            Node<E> currentNode = first;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
            size++;
        }
    }

    public void add(E element){
        addLast(element);
    }

    public void add(E element, int index) {
        if (indexIsCorrect(index)) {
            if (index == 0) {
                addFirst(element);
                return;
            }
            if (index == size) {
                addLast(element);
                return;
            }
            Node<E> newNode = new Node<>(element);
            Node<E> currentNode = first;
            int currentIndex = 0;
            while (currentIndex != index - 1) {
                currentNode = currentNode.next;
                currentIndex++;
            }
            newNode.next = currentNode.next;
            currentNode.next = newNode;
            size++;
        }
    }

    public void deleteFirst() {
        first = first.next;
        size--;
    }

    public void deleteLast() {
        Node<E> currentNode = first;
        int currentIndex = 0;
        while (currentIndex != size - 2) {
            currentNode = currentNode.next;
            currentIndex++;
        }
        currentNode.next = null;
        size--;
    }

    public void delete(int index) {
        if (!indexIsCorrect(index)) {
            return;
        }
        if (index == 0) {
            deleteFirst();
            return;
        }
        Node<E> currentNode = first;
        Node<E> previousNode = first;
        int currentIndex = 0;
        while (currentIndex != index) {
            previousNode = currentNode;
            currentNode = currentNode.next;
            currentIndex++;
        }
        previousNode.next = currentNode.next;
        size--;
    }

    public void removeAll(E element) {
        int index;
        while ((index = getIndex(element)) != -1) {
            delete(index);
        }
    }

    public boolean contains(E element) {
        Node<E> currentNode = first;
        int currentIndex = 0;
        int index = -1;
        while (currentNode != null) {
            if (currentNode.item.equals(element)) {
                index = currentIndex;
                break;
            }
            currentNode = currentNode.next;
        }
        return index != -1;
    }

    private int getIndex(E element) {
        Node<E> currentNode = first;
        int currentIndex = 0;
        int index = -1;
        while (currentNode != null) {
            if (currentNode.item.equals(element)) {
                index = currentIndex;
                break;
            }
            currentNode = currentNode.next;
            currentIndex++;
        }
        return index;
    }

    public E[] toArray(E[] array) {
        Node<E> currentNode = first;
        int index = 0;
        while (currentNode != null) {
            array[index] = currentNode.item;
            currentNode = currentNode.next;
            index++;
        }
        return array;
    }

    public double sumOfAllElements() {
        if(first.item == null){
            return 0.0;
        }
        if (first.item instanceof Number) {
            int sumEl = 0;
            for (int i = 0; i < size; i++) {
                sumEl += ((Number) getElement(i)).doubleValue();
            }
            return sumEl;
        }
        return 0;
    }

    public static <T extends Number> double sumOfAllElements2 (LinkedList<T> list) {
            double sumEl = 0;
            for (int i = 0; i < list.size; i++) {
                sumEl += (list.getElement(i)).doubleValue();
            }
            return sumEl;
    }

    private E getElement(int index) {
        Node<E> currentNode = first;
        int currentIndex = 0;
        while (currentIndex + 1 == index) {
            currentNode = currentNode.next;
            currentIndex++;
        }
        return currentNode.item;
    }

    public void push(E element) {
        addLast(element);
    }

    public void pop() {
        deleteLast();
    }

    public E peek() {
        Node<E> currentNode = first;
        int currentIndex = 0;
        while (currentIndex != size - 1) {
            currentNode = currentNode.next;
            currentIndex++;
        }
        return currentNode.item;
    }


    @Override
    public String toString() {
        StringBuilder strLinkedList = new StringBuilder();
        Node<E> current = first;
        while (current != null) {
            strLinkedList.append(current.item).append(" ");
            current = current.next;
        }
        return strLinkedList.toString();
    }

    private boolean indexIsCorrect(int index) {
        return index >= 0 && index <= size;
    }


    @Override
    public Iterator<E> iterator() {
        return new Iter();
    }

    public class Iter implements Iterator<E>{
        private Node<E> cursor = first;
        private int cursorIndex;
        private int lastReturnedIndex;

        @Override
        public boolean hasNext() {
            return cursorIndex != size;
        }

        @Override
        public E next() {
            if(cursorIndex >= size){
                throw new NoSuchElementException();
            }
            Node<E> lastReturned = cursor;
            cursor = cursor.next;
            lastReturnedIndex = cursorIndex++;
            return lastReturned.item;

        }

        @Override
        public void remove() {
            LinkedList.this.delete(lastReturnedIndex);
            cursorIndex = lastReturnedIndex--;
        }
    }
}
