package LinkedListCollection.part1;

public class LinkedList<E> {
    private Node<E> first; //значение первого элемента
    private int size; //размерность списка

    private static class Node<E> {
        E item; //значение самого элемента
        Node<E> next; //значение следующего
        Node<E> prev; //значение предыдущего

        Node(E element) {
            this.item = element;
        }
    }

    //метод добавления в начало
    public void addFirst(E element) {
        Node<E> newNode = new Node<>(element);
        if (first != null) { //если первый элемент пустой
            newNode.next = first; //то у добавляемого элемента в список ссылка на следующий элемент - ссылка на первый элемент
        }
        first = newNode; //первый элемент - это добавляемый элемент
        size++;
    }

    //метод добавления в конец
    public void addLast(E element) {
        if (first == null) {
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

    //метод удаления из начала
    public void deleteFirst() {
        Node<E> currentNode = first.next;
        first = currentNode;
        size--;
    }

    //метод удаления из конца
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

    //метод удаления по индексу
    public void delete(int index) {
        if (indexIsCorrect(index)) {
            if (index == 0) {
                deleteFirst();
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
    }

    //метод удаления по ключу - удаление всех вхождений элемента
    public void removeAll(E element) {

    }

    //метод проверки, содержится ли элемент в списке
    private void indexOfElement(E element) {

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

    private boolean indexIsCorrect(int index) {
        return index >= 0 && index <= size;
    }
}
