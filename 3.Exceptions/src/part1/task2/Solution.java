package part1.task2;

public class Solution {
    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40, 50};
        try {
            System.out.println(getElement(array, 10));
        }
        catch (ArrayIndexOutOfBoundsException exception){
            System.out.println(exception.getMessage());
        }

    }

    public static void print(int[] array){
        for (int element:array) {
            System.out.println(element);
        }
    }

    public static int getElement(int[] array, int index){
        if(index < 0 || index >= array.length){
            throw new ArrayIndexOutOfBoundsException("--");
        }
        return array[index];
    }

}
