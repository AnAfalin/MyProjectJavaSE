package part1.task3;

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String str = "This string is text of task3";
        try (FileWriter fw = new FileWriter("6.StreamInputOutput/src/part1/task3/Task3.txt");
             FileReader fr = new FileReader("6.StreamInputOutput/src/part1/task3/Task3.txt")){
            fw.write(str);

            int c;
            while ((c = fr.read()) != -1) {
                System.out.print((char) (c));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
