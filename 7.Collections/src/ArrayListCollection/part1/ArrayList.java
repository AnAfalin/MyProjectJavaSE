package ArrayListCollection.part1;

public class ArrayList<E> {
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
                for (int i = size; i > index; i--) {
                    array[i] = array[i - 1];
                }
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
    public void delete(int index){
        if(indexIsCheck(index)) {
            for (int i = index; i < size; i++) {
                array[i] = array[i + 1];
            }
            size--;
        }
    }

    //метод удаления из начала      O(n)
    public void deleteFirst(){
        delete(0);
    }

    //метод удаления из конца       O(1)
    public void deleteLast(){
        delete(size-1);
    }

    //метод получения элемента по индексу   O(1)
    @SuppressWarnings("unchecked")
    public E get(int index){
        exceptionCheckIndex(index);
        return (E) array[index];
    }

    //метод изменения значения элемента по инждексу     O(1)
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

            for (int i = 0; i < size; i++) {
                newArr[i] = array[i];
            }

            array = newArr;
        }
    }

    //метод увеличения внутреннего размера массива, чтобы в него поместилось minCapacity элементов
    public void ensureCapacity(int minCapacity){
        if(minCapacity > array.length) {
            grow(minCapacity);
        }
    }

    //метод, возвращающий массив элементов      O(n)
    @SuppressWarnings("unchecked")
    public <E> E[] toArray(E[] arr){
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

    //метод, сортирующий список
    public void sort(){

    }

    private void exceptionCheckIndex(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Введен неверный индекс");
        }
    }

    private boolean indexIsCheck(int index){
        return index >=0 && index <= size;
    }
}

