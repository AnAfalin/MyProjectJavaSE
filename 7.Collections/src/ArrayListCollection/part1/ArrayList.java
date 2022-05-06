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
        if (size + 1 >= capacity) {
            grow();
        }
        add(el, size);
    }

    //метод добавления по любому индексу
    public void add(E el, int index) {
        if (size + 1 >= capacity) {
            grow();
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = el;
        size++;
    }

    //метод добавления в начало
    public void addFirst(E el) {
        if (size + 1 >= capacity) {
            grow();
        }
        add(el, 0);
    }

    //метод добавления - основной
    private void add(E el, int index, E[] array) {
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = el;
        size++;
    }

    private void grow() {
        Object[] newArr = new Object[(int) (capacity * 1.5 + 1)];
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

    //метод удаления
    public void delete(int index){
        for (int i = index; i < size; i++) {
            array[i] = array[i+1];
        }
        size--;
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
}

