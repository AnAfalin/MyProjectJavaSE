package ArrayListCollection.part1;

public class ArrayList<E> {
    private int size;
    private int capacity;
    private E[] array;

    @SuppressWarnings("unchecked")
    public ArrayList() {
        capacity = 10;
        size = 0;
        array = (E[]) new Object[capacity];
    }

    //метод добавления в конец
    public void add(E el) {
        if (size + 1 >= capacity) {
            grow();
        }
        add(el, size, array);

    }

    //метод добавления по любому индексу
    public void add(E el, int index) {
        if (size + 1 >= capacity) {
            grow();
        }
        add(el, index, array);

    }

    //метод добавления в начало
    public void addFirst(E el) {
        if (size + 1 >= capacity) {
            grow();
        }
        add(el, 0, array);
    }

    //метод добавления - основной
    private void add(E el, int index, E[] array) {
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = el;
        size++;
    }

    @SuppressWarnings("unchecked")
    private void grow() {
        Object[] newArr = new Object[(int) (capacity * 1.5 + 1)];
        System.arraycopy(array, 0, newArr, 0, array.length);
        array = (E[]) newArr;
    }

    //метод вывода на консоль списка
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}


class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(30);
        list.add(40);
        list.print();
        list.addFirst(0);
        list.add(20, 2);
        list.print();
    }
}
