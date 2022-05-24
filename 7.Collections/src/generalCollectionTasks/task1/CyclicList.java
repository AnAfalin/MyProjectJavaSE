package generalCollectionTasks.task1;

public class CyclicList<E> {
    private Node<E> first;
    public int size;

    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E element) {
            this.item = element;
        }
    }

    public void add(E element){
        addLast(element);
    }

    public void add(E element, int index) {
        if (indexIsCorrect(index)) {
            if (index == 0) {
                addFirst(element);
            }else if (index == size + 1) {
                addLast(element);
            }else {
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
    }

    public void addFirst(E element) {
        Node<E> newNode = new Node<>(element);

        if (first != null) {
            Node<E> currentNode = first;
            while (currentNode.next != first) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
            newNode.next = first;
            first = newNode;
            size++;
            return;
        }

        first = newNode;
        first.next = first;
        size++;
    }

    public void addLast(E element) {
        if (first == null) {
            addFirst(element);
            return;
        }

        Node<E> newNode = new Node<>(element);
        newNode.next = first;
        Node<E> currentNode = first;

        while (currentNode.next != first) {
            currentNode = currentNode.next;
        }

        currentNode.next = newNode;
        size++;
    }

    private boolean indexIsCorrect(int index) {
        return index >= 0 && index <= size;
    }

    @Override
    public String toString() {
        StringBuilder strList = new StringBuilder("");
        Node<E> currentNode = first;
        while (true) {
            if(currentNode.next == first){
                strList.append(currentNode.item);
                break;
            }
            strList.append(currentNode.item).append(" ");
            currentNode = currentNode.next;
        }
        return strList.toString();
    }
}



