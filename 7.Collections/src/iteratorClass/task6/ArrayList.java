package iteratorClass.task6;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements Iterable<E> {
    private int size;
    private int capacity;
    private Object[] array;

    public ArrayList() {
        capacity = 10;
        size = 0;
        array = new Object[capacity];
    }

    //метод добавления в конец  O(1)
    public void add(E el) {
        add(el, size);
    }

    //метод добавления по любому индексу  O(n)
    public void add(E el, int index) {
        if (indexIsCheck(index)) {

            if (size + 1 == capacity) {
                grow();
            }

            if(index != size){
                if (size - index >= 0) System.arraycopy(array, index, array, index + 1, size - index);
            }
            array[index] = el;
            size++;
        }
    }

    //метод добавления в начало     O(n)
    public void addFirst(E el) {
        add(el, 0);
    }

    //метод расширения  O(n)
    private void grow() {
        Object[] newArr = new Object[(int) (capacity * 1.5 + 1)];

        //O(n)
        System.arraycopy(array, 0, newArr, 0, array.length);
        array = newArr;
    }

    private void grow(int minCapacity) {
        Object[] newArr = new Object[minCapacity];
        System.arraycopy(array, 0, newArr, 0, array.length);
        array = newArr;
    }

    //метод вывода списка
    @Override
    public String toString() {
        StringBuilder arrayStr = new StringBuilder();
        for (int i = 0; i < size; i++) {
            arrayStr.append(array[i]).append(" ");
        }
        return arrayStr.toString();
    }

    //метод удаления по индексу     O(n)
    public void remove(int index){
        if(indexIsCheck(index)) {
            if (size - index >= 0) System.arraycopy(array, index + 1, array, index, size - index);
            size--;
        }
    }

    //метод удаления из начала      O(n)
    public void removeFirst(){
        remove(0);
    }

    //метод удаления из конца       O(1)
    public void removeLast(){
        remove(size-1);
    }

    //метод получения элемента по индексу   O(1)
    @SuppressWarnings("unchecked")
    public E get(int index){
        exceptionCheckIndex(index);
        return (E) array[index];
    }

    //метод изменения значения элемента по индексу     O(1)
    @SuppressWarnings("unchecked")
    public E set(E el, int index){
        E oldValue = (E) array[index];
        array[index] = el;
        return oldValue;
    }

    //метод проверки, содержится ли элемент в списке    O(n)
    public boolean contains(E el){
        for (int i = 0; i < size; i++) {
            if (array[i].equals(el)) {
                return true;
            }
        }
        return false;
    }

    //метод сокращения размера внутреннего массива до size  O(n)
    public void trimToSize(){
        if (size != capacity){
            capacity = size;

            Object[] newArr = new Object[capacity];

            System.arraycopy(array, 0, newArr, 0, size);
            array = newArr;
        }
    }

    //метод увеличения внутреннего размера массива, чтобы в него поместилось minCapacity элементов      O(grow)
    public void ensureCapacity(int minCapacity){
        if(minCapacity > array.length) {
            grow(minCapacity);
        }
    }

    //метод, возвращающий массив элементов      O(n)
    @SuppressWarnings("unchecked")
    public E[] toArray(E[] arr){
        Object[] ar = new Object[size - 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (E) array[i];
        }
        return arr;
    }

    //метод, добавляющий в текущий список все элементы из другого списка        O(n)
    public void addAll(ArrayList<E> list){
        for (int i = 0; i < list.size; i++) {
            this.add(list.get(i));
        }
    }

    //метод, сортирующий список     O(n^2)
    @SuppressWarnings("unchecked")
    public void sort(Comparator<E> comparator){

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if(comparator.compare((E)array[i], (E)array[j]) > 0){
                    Object temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    private void exceptionCheckIndex(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Введен неверный индекс");
        }
    }

    private boolean indexIsCheck(int index){
        return index >=0 && index <= size;
    }

    public class Iter implements Iterator<E>{
        int cursor;             //курсор следующего элемента, который необходимо вернуть при вызове next.
        int lastReturned = -1;  //индекс последнего возвращенного элемента, для удаления последнего элемента


        @Override
        public boolean hasNext() {
            return cursor != size;          //достигнут ли конец списка
        }

        @SuppressWarnings("unchecked")
        @Override
        public E next() {
            if(cursor >= size){                         //если индекс следующего элемента больше или равен размеру массива
                throw new NoSuchElementException();     //то генерируется исключение
            }

            lastReturned = cursor++;        //сохранение индекса последнего элемента и смещение курсора на следующий элемент

            return (E) ArrayList.this.array[lastReturned];     //возвращается элемент под индексом cursor-1 или lastReturned
        }

        @Override
        public void remove() {
            if(lastReturned < 0){                   //если индекс последнего возвращенного элемента меньше нуля (нет такого элемента),
                throw  new IllegalStateException(); //то генерируется исключение
            }

            ArrayList.this.remove(lastReturned);
            cursor = lastReturned;
            lastReturned--;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iter();
    }
}

