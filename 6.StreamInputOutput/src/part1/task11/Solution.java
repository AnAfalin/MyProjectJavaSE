package part1.task11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("6.StreamInputOutput/src/part1/task11/LargeNumber.txt"))) {
            String str = bufferedReader.readLine();

            int[] arrNum = new int[10];
            for (int i = 0; i < str.length(); i++) {
                int number = Integer.parseInt(String.valueOf(str.charAt(i)));
                arrNum[number] += 1;
            }

            System.out.println("В считанном файле содержалось большое число: " + str + ", в котором:");
            for (int i = 0; i < arrNum.length; i++) {
                System.out.println("кол-во вхождений цифры " + i + " составляет " + arrNum[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
