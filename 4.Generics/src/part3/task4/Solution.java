package part3.task4;

public class Solution {
    @SafeVarargs
    public final <T> void printArguments(T element, T...args){
        System.out.println("Вывод первого аргумента: ");
        System.out.println(element);
        System.out.println("Вывод второго аргумента");
        for (var arg:args) {
            System.out.println(arg);
        }
    }

}


class Main{
    public static void main(String[] args) {
        new Solution().printArguments("String", 10, 20, 30, 40, 50);
    }
}