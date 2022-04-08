package part1.task2;

public class Solution {
    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40, 50};
        System.out.println(getElement(array, 10));
        int[] arrNull = null;
        print(arrNull);
    }

    public static void print(int[] array){
        try {
            for (int element:array) {
                System.out.println(element);
            }
        }catch (NullPointerException exception) {
            System.out.println("Команды в методе не могут быть осущестлены с null. Необхожим Объект!");
        }
    }

    public static int getElement(int[] array, int index){
        int foundElement;
        try {
            foundElement = array[index];
        }catch (ArrayIndexOutOfBoundsException ex) {
            System.out.print("Вы ввели индекс, значение которого выходит за пределы границ указанного массива. Exception massege: ");
            System.out.println(ex.getMessage());
        }finally {
            System.out.println("Крайний элемент в массиве под индексом " + (array.length - 1));
            foundElement = array[array.length-1];
        }
        return foundElement;
    }

}
