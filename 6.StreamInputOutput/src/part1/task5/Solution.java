package part1.task5;

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (OutputStream os = new FileOutputStream("6.StreamInputOutput/src/part1/task5/Task5.txt");
             InputStream is = new FileInputStream("6.StreamInputOutput/src/part1/task5/Task5.txt");
             DataOutputStream dos = new DataOutputStream(os);
             DataInputStream dis = new DataInputStream(is)) {

            for (int i = 0; i < 10; i++) {
                dos.writeInt(i * 2);
                for (int k = 0; k < 10; k++) {
                    System.out.println(dis.readInt());
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
