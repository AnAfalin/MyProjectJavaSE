package part1.task3;

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String str = "This string is text of task3";
        try (FileWriter fw = new FileWriter("Task3.txt")){
            fw.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileReader fr = new FileReader("Task3.txt")) {
            int c;
            while ((c = fr.read()) != -1) {
                System.out.print((char) (c));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
