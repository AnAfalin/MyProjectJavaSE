package LinkedListCollection.part1;

public class LinkedList<E> {
    private Node<E> first;
    private int size;

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(E element) {
            this.item = element;
        }
    }

    //метод добавления в начало
    public void addFirst(E element) {
        Node<E> newNode = new Node<>(element);
        if (first != null) { //если первый элемент пустой
            newNode.next = first; //у добавляемого элемента в список ссылка на следующий элемент - ссылка на первый элемент
        }
        first = newNode; //то первый элемент - это добавляемый элемент
        size++;
    }

    //метод добавления в конец
    public void addLast(E element) {
        if (first == null) { //если первый элемент пустой
            addFirst(element);
        } else {
            Node<E> newNode = new Node<>(element);
            Node<E> current = first;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            size++;
        }
    }

    //метод произвольного добавления
    public void add(E element, int index) {
        if (indexIsCorrect(index)) {
            if (index == 0) {
                addFirst(element);
                return;
            }
            if (index == size){
                addLast(element);
                return;
            }
            Node<E> newNode = new Node<>(element);
            Node<E> currentNode = first;
            int currentIndex = 0;
            while (currentIndex != index - 1){
                currentNode = currentNode.next;
                currentIndex++;
            }
            newNode.next = currentNode.next;
            currentNode.next = newNode;
            size++;
        }
    }

    //метод вывода на консоль
    @Override
    public String toString() {
        String strLinkedList = "";
        Node<E> current = first;
        while (current != null) {
            strLinkedList += current.item + " ";
            current = current.next;
        }
        return strLinkedList;
    }

    private boolean indexIsCorrect(int index){
        return index >=0 && index <=size;
    }
}
