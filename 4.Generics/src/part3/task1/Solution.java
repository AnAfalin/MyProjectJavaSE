package part3.task1;

public class Solution {
    public static void infoArgs(int...args){
        int sumElements = sumElements(args);
        int maxElement = maxElement(args);
        int minElement = minElement(args);
        System.out.printf("Сумма всех переданных аргументов: %d\nМаксимальное из аргументов число %d\nМинимальное из аргументов число %d", sumElements, maxElement, minElement);
    }

    private static int sumElements(int...args){
        int sum = 0;
        for (int el:args) {
            sum += el;
        }
        return sum;
    }

    private static int maxElement(int...args){
        int max = Integer.MIN_VALUE;
        for (int el:args) {
            if(el > max) {
                max = el;
            }
        }
        return max;
    }

    private static int minElement(int...args){
        int min = Integer.MAX_VALUE;
        for (int el:args) {
            if(el < min) {
                min = el;
            }
        }
        return min;
    }
}

class Main{
    public static void main(String[] args) {
        Solution.infoArgs(45, 80, -80, -5, 60, 95);
    }
}
