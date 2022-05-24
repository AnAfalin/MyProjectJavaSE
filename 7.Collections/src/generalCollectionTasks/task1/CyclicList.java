package generalCollectionTasks.task1;

public class CyclicList<E> {
    private Node<E> first; //значение первого элемента
    public int size; //размерность списка

    private static class Node<E> {
        E item; //значение самого элемента
        Node<E> next; //значение следующего

        Node(E element) {
            this.item = element;
        }
    }

    public void add(E element, int index) {
        if (indexIsCorrect(index)) {
            if (index == 0) {
                addFirst(element);
                return;
            }
            if (index == size + 1) {
                addLast(element);
                return;
            }
            else {
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

        if (first == null) {
            first = newNode;
            first.next = first;
        } else if (size == 1) {
            newNode.next = first;
            first = newNode;
            first.next.next = first;
        } else {
            newNode.next = first;
            first = newNode;
        }
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
                strList.append(currentNode.item).append(" ");
                break;
            }
            strList.append(currentNode.item).append(" ");
            currentNode = currentNode.next;
        }
        return strList.toString();
    }
}


class Main {
    public static void main(String[] args) {
        CyclicList<Integer> cyclicList = new CyclicList<>();

        cyclicList.addFirst(5);
        cyclicList.addFirst(0);
        cyclicList.addLast(10);
        cyclicList.addLast(20);
        cyclicList.add(44, 3);
        System.out.println(cyclicList);
    }
}
