package part1.task5;

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (OutputStream os = new FileOutputStream("Task5.txt")) {
            try (DataOutputStream dos = new DataOutputStream(os)) {
                for (int i = 0; i < 10; i++) {
                    dos.writeInt(i*2);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (InputStream is = new FileInputStream("Task5.txt")){
            try (DataInputStream dis = new DataInputStream(is)) {
                for (int i = 0; i < 10; i++) {
                    System.out.println(dis.readInt());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
