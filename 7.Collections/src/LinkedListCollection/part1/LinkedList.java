package linkedListCollection.part1;

public class LinkedList<E> {
    private Node<E> first; //значение первого элемента
    public int size; //размерность списка

    private static class Node<E> {
        E item; //значение самого элемента
        Node<E> next; //значение следующего
        Node<E> prev; //значение предыдущего

        Node(E element) {
            this.item = element;
        }
    }

    //метод добавления в начало      O(1)-вставка O(n)-итерация по всему списку до конца и изменение их ссылкон на след.эл.
    public void addFirst(E element) {
        Node<E> newNode = new Node<>(element);
        if (first != null) { //если первый элемент пустой
            newNode.next = first; //то у добавляемого элемента в список ссылка на следующий элемент - ссылка на первый элемент
        }
        first = newNode; //первый элемент - это добавляемый элемент
        size++;
    }

    //метод добавления в конец      O(n)-итерация до конца списка   O(1)-вставка
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

    //метод произвольного добавления    O(n)-поиск элемента   O(1)-вставка
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

    //метод удаления из начала  O(1)
    public void deleteFirst() {
        first = first.next;
        size--;
    }

    //метод удаления из конца   O(1)
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

    //метод удаления по индексу     O(n)-поиск элемента   O(1)-удаление
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

    //метод удаления по ключу - удаление всех вхождений элемента
    public void removeAll(E element) {
        int index;
        while ((index = getIndex(element)) != -1) {
            delete(index);
        }
    }

    //метод проверки, содержится ли элемент в списке    O(n)
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

    //O(n)
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

    //метод, возвращающий массив элементов      O(n)
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

    //метод нахождения суммы всех элементов     O(n)
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

    //метод нахождения суммы всех элементов
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

    //метод вывода на консоль
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
}
