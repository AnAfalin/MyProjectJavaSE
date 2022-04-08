package part1.task7;

public class Solution {

    public static void main(String[] args) throws Exception {
        generateLuckyNumber();
    }

    public static void generateLuckyNumber() throws Exception {
        int luckyNumber = (int) (Math.random() * 100);
        if (luckyNumber == 13) {
            throw new Exception("не повезло");
        }
        System.out.println("твое счастливое число: " + luckyNumber);
    }
}



