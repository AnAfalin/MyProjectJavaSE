package part1.task2;

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             OutputStream os = new FileOutputStream("6.StreamInputOutput/src/part1/task2/Task2.txt");
             InputStream is = new FileInputStream("6.StreamInputOutput/src/part1/task2/Task2.txt");
             BufferedOutputStream bos = new BufferedOutputStream(os);
             BufferedInputStream bis = new BufferedInputStream(is)) {
            String text = scanner.nextLine();

            bos.write(text.getBytes());
            int c;
            while ((c = bis.read()) != -1) {
                System.out.print((char) (c));
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }
}
