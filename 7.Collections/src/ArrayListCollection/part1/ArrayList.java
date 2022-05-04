package ArrayListCollection.part1;

public class ArrayList<T> {
    private int size;
    private int capacity;
    private T[] array;

    @SuppressWarnings("unchecked")
    public ArrayList() {
        array = (T[]) new Object[capacity];
    }





}
