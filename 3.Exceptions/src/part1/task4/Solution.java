package part1.task4;

public class Solution {
    public static void alarm(int start, int end) {
        if(start < 0 || start > 24) {
            throw new IllegalArgumentException("Введено неверное время начала оповещения");
        }
        if(end < 0 || end > 24) {
            throw new IllegalArgumentException("Введено неверное время конца оповещения");
        }
        System.out.printf("Оповещение будет включено в %d и выключено в %d", start, end);
    }

    public static void main(String[] args) {
        alarm(10, 25);
    }
}
