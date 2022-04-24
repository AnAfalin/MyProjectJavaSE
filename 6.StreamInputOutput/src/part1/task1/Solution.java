package part1.task1;

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in);
             OutputStream outputStream = new FileOutputStream("6.StreamInputOutput/src/part1/task1/Task1.txt");
             InputStream is = new FileInputStream("6.StreamInputOutput/src/part1/task1/Task1.txt")) {
            String str = scanner.nextLine();
            byte[] arr = str.getBytes();
            outputStream.write(arr);
            int c;
            while ((c = is.read()) != -1) {
                System.out.print((char) (c));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
