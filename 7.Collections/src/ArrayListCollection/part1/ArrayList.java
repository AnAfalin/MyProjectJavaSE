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

    //метод добавления в конец
    public void add(E el) {
        add(el, size);
    }

    //метод добавления по любому индексу
    public void add(E el, int index) {
        if (indexIsCheck(index)) {

            if (size + 1 == capacity) {
                grow();
            }

            for (int i = size; i > index; i--) {
                array[i] = array[i - 1];
            }
        }
        array[index] = el;
        size++;
    }

    //метод добавления в начало
    public void addFirst(E el) {
        add(el, 0);
    }

    //метод расширения
    private void grow() {
        Object[] newArr = new Object[(int) (capacity * 1.5 + 1)];
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

    //метод удаления по индексу
    public void delete(int index){
        if(indexIsCheck(index)) {
            for (int i = index; i < size; i++) {
                array[i] = array[i + 1];
            }
            size--;
        }
    }

    //метод удаления из начала
    public void deleteFirst(){
        delete(0);
    }

    //метод удаления из конца
    public void deleteLast(){
        delete(size-1);
    }

    //метод получения элемента по индексу
    @SuppressWarnings("unchecked")
    public E get(int index){
        exceptionCheckIndex(index);
        return (E) array[index];
    }

    //метод изменения значения элемента по инждексу
    @SuppressWarnings("unchecked")
    public E set(E el, int index){
        E oldValue = (E) array[index];
        array[index] = el;
        return oldValue;
    }

    //метод проверки, содержится ли элемент в списке
    public boolean contains(E el){
        for (int i = 0; i < size; i++) {
            if (array[i].equals(el)) {
                return true;
            }
        }
        return false;
    }

    //метод сокращения размера внутреннего массива до size
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

    //метод, возвращающий массив элементов
    @SuppressWarnings("unchecked")
    public <E> E[] toArray(E[] arr){
        Object[] ar = new Object[size - 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (E) array[i];
        }
        return arr;
    }

    //метод, добавляющий в текущий список все элементы из другого списка
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
        return index >= 0 && index < size;
    }
}

