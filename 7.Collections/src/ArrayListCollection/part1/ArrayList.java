package ArrayListCollection.part1;

public class ArrayList<E> {
    private int size;
    private int capacity;
    private Object[] array;
    @SuppressWarnings("unchecked")
    public ArrayList() {
        capacity = 10;
        size = 0;
        array = new Object[capacity];
    }

    //метод добавления в конец
    public void add(E el) {
        if (size + 1 >= capacity) {
            grow();
        }
        add(el, size, array);
        size++;
    }

    //метод добавления по любому индексу
    public void add(E el, int index) {
        if (size + 1 >= capacity) {
            grow();
        }
        add(el, index, array);
        size++;
    }

    //метод добавления в начало
    public void addFirst(E el) {
        if (size + 1 >= capacity) {
            grow();
        }
        add(el, 0, array);
    }

    //метод добавления - основной
    private void add(E el, int index, Object[] array) {
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = el;
    }

    @SuppressWarnings("unchecked")
    private void grow() {
        Object[] newArr = new Object[(int) (capacity * 1.5 + 1)];
        System.arraycopy(array, 0, newArr, 0, array.length);
        array = newArr;
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
        list.add(5);
        list.add(10);
        list.add(15);
        list.print();
        list.addFirst(88);
        list.add(88, 2);
        list.print();
    }
}
