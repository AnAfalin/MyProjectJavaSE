package part2.task1;

public class MyArrayList {
    Integer[] data;
    int capacity;
    int size;

    public MyArrayList() {
        capacity = 10;
        size = 0;
        data = new Integer[capacity];
    }

    //метод добавления элемента
    public void add(int element) {
        if(size + 1 == capacity) {
            grow();
        }
        data[size] = element;
        size++;
    }

    //метод добавления элемента по индексу (вставка)
    public boolean add(int element, int index) {
        if(isCheckIndex(index)) {

            if (size + 1 == capacity) {
                grow();
            }

            for (int i = size; i > index; i--) {
                data[i] = data[i - 1];
            }

        data[index] = element;
        size++;
        }
        return true;
    }

    //метод вставки элемента в начало списка
    public void addFirst(int element) {
        if(size + 1 == capacity) {
            grow();
        }

        for (int i = size; i >= 0; i--) {
            data[i+1] = data[i];
        }
        data[0] = element;
        size++;
    }

    //метод поиска элемента - проверка содержит ли список элемент
    public boolean contains(int element) {
        for (int i = 0; i < size; i++) {
            if(data[i] == element) {
                return true;
            }
        }
        return false;
    }

    //метод вывода индекса элемента, который проверялся содержится или нет
    public int indexOf(int element) {
        int index = -1;
        if(contains(element)) {
            for (int i = 0; i < size; i++) {
                if (data[i] == element) {
                    index = i;
                    return index; //или break; для поиска первого вхождения
                }
            }
        }
        return index;
    }

    //метод удаления элемента по индесу
    public boolean delete(int index) {
        if(isCheckIndex(index)) {

            for (int i = index + 1; i < capacity; i++) {
                data[i - 1] = data[i];
            }
        }
        size--;
        return true;
    }

    //метод удаления элемента из конца списка
    public boolean deleteLast() {
        if(size != 0) {
            size--;
        }
        return true;
    }

    //метод получения значения элемента по индексу
    public int get(int index) {
        exceptionCheckIndex(index);
        return data[index];
    }
    //метод изменения элемента по индексу
    public void set(int newValue, int index) {
        data[index] = newValue;
    }

    //метод trimToSize - сокращение размера внутреннего массива до size
    public void trimToSize(){

        if (size != capacity) {

            capacity = size;

            Integer[] temp = new Integer[capacity];

            for(int i = 0; i < size; i++) {
                temp[i] = data[i];
            }
            data = temp;
        }
    }

    //метод вывода на печать
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public void printAllElements() {
        for (int i = 0; i < capacity; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    //вспомогательный метод - расширение
    private void grow() {
        capacity = (int)(capacity * 1.5 +1);
        Integer[] newArr = new Integer[capacity];
        for (int i = 0; i < data.length; i++) {
            newArr[i] = data[i];
        }
        data = newArr;
    }

    private void exceptionCheckIndex(int index) {
        if(index < 0 || index >= capacity) {
            throw new IndexOutOfBoundsException("Введен неверный индекс");
        }
    }

    private boolean isCheckIndex(int index) {
        if(index < 0 || index >= capacity) {
            return false;
        }
        return true;
    }

}

