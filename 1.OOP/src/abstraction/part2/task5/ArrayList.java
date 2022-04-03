package abstraction.part2.task5;

public class ArrayList implements List{
    private int[] array;
    private int size;
    private int capacity = 10;

    public ArrayList() {
        array = new int[capacity];
        size = 0;
    }

    @Override
    public boolean add(int element) {
        if(size + 1 == 10) {
            row();
        }
        array[size] = element;
        size++;
        return true;
    }

    @Override
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    @Override
    public void deleteElement(int index) {
        if(index < 0 || index >= array.length) {
            System.out.println("Неверный индекс");
        }

        for (int i = index; i < size ; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    private void row(){
        capacity = capacity * 2;
        int[] newArr = new int[capacity];
        System.arraycopy(array, 0, newArr, 0, array.length);
        array = newArr;
        size--;
    }

    public static void main(String[] args) {
        ArrayList al = new ArrayList();
        al.add(10);
        al.add(20);
        al.add(30);
        al.print();
        al.add(40);
        al.add(50);
        al.add(60);
        al.print();
        al.deleteElement(1);
        al.print();
    }
}
