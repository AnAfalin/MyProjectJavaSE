package abstraction.part3.task1;

import java.util.Arrays;

public class Array implements Service{
    private int[] array;
    private final int size;


    public Array(int size) {
        this.size = size;
    }

    @Override
    public Object makeObject() {
        array = new int[size];
        return array;
    }

    @Override
    public String makeString() {
        return Arrays.toString(array);
    }

    @Override
    public void clear() {
        Arrays.fill(array, 0, array.length - 1, 0);
    }
}
