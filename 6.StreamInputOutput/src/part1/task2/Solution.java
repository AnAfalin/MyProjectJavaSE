package part1.task2;

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             OutputStream os = new FileOutputStream("Task2.txt")) {
            String text = scanner.nextLine();
            try(BufferedOutputStream bos = new BufferedOutputStream(os)){
                bos.write(text.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (InputStream is = new FileInputStream("Task2.txt")) {
            try (BufferedInputStream bis = new BufferedInputStream(is)) {
                int c;
                while ((c = bis.read()) != -1){
                    System.out.print((char)(c));
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
