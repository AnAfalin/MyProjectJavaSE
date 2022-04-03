package basics.part1.task3;

import java.util.Scanner;

public class MyArray {
    int[] arr;

    //метод для заполнения массива
    public void fill () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер вашего массива - целое число");
        arr = new int[scanner.nextInt()];
        System.out.println("Введите целые числа " + arr.length + " раз");
        for (int i = 0; i < arr.length; i++) {
            if(scanner.hasNextInt()) {
                arr[i] = scanner.nextInt();
            }
        }
        scanner.close();
    }

    //метод вывода на консоль
    public void print() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //метод суммы массива
    public int sum() {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    //метод среднего значения массива
    public double middleValue() {
        return (double) (sum()) / (double) (arr.length);
    }

    //метод проверки содержит ли массив только положительные значения или нет
    public boolean isPositive() {
        boolean isPositive = true;
        for (int el : arr) {
            if(el < 0) {
                isPositive = false;
                break;
            }
        }
        return isPositive;
    }

    //метод, находящий количество отрицательных элементов
    public int countNegative() {
        int count = 0;
        for (int el : arr) {
            if(el < 0) {
                count ++;
            }
        }
        return count;
    }

    //метод, меняющий все отрицательные значения на положительные
    public void positiveAll() {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < 0) {
                arr[i] = arr[i] * -1;
            }
        }
    }
}

