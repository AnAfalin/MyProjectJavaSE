package linkedlist;

public class MyLinkedList {
    int size;//размер связного списка
    private Node first;//первый элемент в связном списке

    public class Node {
        int data; //значение элемента
        Node next;//ссылка на следующий элемент

        Node(int d) {
            data = d;
        }
    }

    //метод вывода на печать
    public void print() {
        Node current = first; //текущий node
        while (current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
       // System.out.print(current.data);
        System.out.println();
    }

    //метод добавление элемента в начало
    public void addFirst(int element) {
        Node newNode = new Node(element);
        if (size != 0) {
            newNode.next = first;
        }
        first = newNode;
        size++;
    }

    //метод добавления элемента по индексу
    public void add(int element, int index) {
        if (!isCheckIndex(index)) {
            return;
        }
        if (size == 0) {
            addFirst(element);
            return;
        }
        Node newNode = new Node(element);
        int currentIndex = 0;
        Node current = first;
        while (currentIndex != index - 1) {
            current = current.next;
            currentIndex++;
        }
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    //метод добавления элемента в конец
    public void addLast(int element) {
        if (size == 0) {
            addFirst(element);
        }else {
            Node newNode = new Node(element);
            Node current = first;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            size++;
        }
    }

    //метод удаления элемента из начала
    public boolean deleteLFirst() {
        if (size == 0) {
            return false;
        }
        first = first.next;
        size--;
        return true;
    }

    //метод удаления элемента по индексу
    public boolean delete(int index) {
        if (!isCheckIndex(index)) {
            return false;
        }
        if (size == 0) {
            return false;
        }
        Node current = first; //текущий
        Node previous = first; //предыдущий

        int currentIndex = 0;

        while (currentIndex != index) {
            previous = current;
            current = current.next;
            currentIndex++;
        }
        if (previous == current) {
            deleteLFirst();
        }else {
            previous.next = current.next;
            size--;
        }
        return true;
    }

    //метод удаления элемента с конца
    public boolean deleteLast() {
        if (size == 0) {
            return false;
        }
        if (size == 1) {
            deleteLFirst();
        }
        delete(size - 1);
        size--;
        return true;

    }

    //Поиск по индексу: получение элемента по заданному индексу
    public int contains(int index) {
        exceptionCheckIndex(index);
        Node foundNode = first;
        int currentIndex = 0;
        while (currentIndex != index-1) {
            foundNode = foundNode.next;
            currentIndex++;
        }
        return foundNode.data;
    }

    //метод нахождения суммы элементов списка (return sum)
    public int sum() {
        int sum = 0;
        Node current = first;
        int currentIndex = 0;
        while (currentIndex != size) {
            sum += current.data;
            current = current.next;
            currentIndex++;
        }
        return sum;
    }

    //метод проверки индекса
    private boolean isCheckIndex(int index) {
        if (index < 0 || index > size) {
            System.out.println("Введен неверный индекс");
            return false;
        }
        return true;
    }

    //метод проверки индекса
    private void exceptionCheckIndex(int index) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Введен неверный индекс");
        }
    }

    //метод реверса значений первого элемента списка с последним. Пример: 10, 20, 30, 40 -> 40, 20, 30, 10
    public void reverse() {
        if(size == 0) {
            return;
        }

        Node nodeFirst = first;
        Node current = first;
        int data = 0;

        for (int i = 0; i < size; i++) {
            if (current.next != null) {
                current = current.next;
            } else {
                data = current.data;
                current.data = nodeFirst.data;
                nodeFirst.data = data;
            }
        }
    }
}

class MainMyLinkedList {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        System.out.println(list.size);
        list.print();
        list.reverse();
        list.print();

    }
}
