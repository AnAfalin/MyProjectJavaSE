package part1.task1;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in);
             OutputStream outputStream = new FileOutputStream("Task1.txt")) {
            String str = scanner.nextLine();
            byte[] arr = str.getBytes();
            outputStream.write(arr);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (InputStream is = new FileInputStream("Task1.txt")) {
            int c;
            while ((c = is.read()) != -1) {
                System.out.print((char) (c));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
