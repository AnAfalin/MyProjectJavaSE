package part1.task3;

public class MyArrayList<T> {
    private T[] array;
    private int size;

    public MyArrayList(T[] array) {
        this.array = array;
    }

    //метод добавления элемента
    public void add(T element){
        checkIndex(size);
        array[size] = element;
        size++;
    }

    //метод удаления элемента по индексу
    public boolean delete(int index) {
        checkIndex(index);
        for (int i = index; i < size-1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return true;
    }
    //метод удаления элемента из начала
    public void deleteFirst(){
        delete(0);
    }


    //метод удаления элемента по индексу
    public T getElement(int index){
        checkIndex(index);
        return array[index];
    }

    //метод изменения (set) элемента по индексу.
    public void set(T element, int index){
        checkIndex(index);
        array[index] = element;
    }

    private void checkIndex(int index){
        if (index < 0 || index >= array.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void print(){
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        Integer[] array = new Integer[10];
        MyArrayList<Integer> list = new MyArrayList<>(array);
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.print();
        list.delete(0);
        list.add(55);
        list.print();
        list.set(5,4);
        list.print();
        list.getElement(55);

    }
}
