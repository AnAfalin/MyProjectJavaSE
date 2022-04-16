package part3.task3;

public class Solution<T> {
    public static <T> double sumArgs(Number...args){
        double sum = 0;
        for (Number el:args) {
            sum += el.doubleValue();
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumArgs(40, 40.5, 0.1));
    }
}
