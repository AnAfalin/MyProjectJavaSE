package part1.task6;

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] matrix = new int[]{10,20,30,40,50};
        StringBuffer strb = new StringBuffer();
        for (int i = 0; i < matrix.length; i++) {
            strb.append(matrix[i]);
            strb.append(" ");
        }
        String str = strb.toString();
        try (FileWriter fw = new FileWriter("6.StreamInputOutput/src/part1/task1/Task6.txt")){
            fw.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileReader fr = new FileReader("6.StreamInputOutput/src/part1/task1/Task6.txt")) {
            int c;
            while ((c = fr.read()) != -1) {
                System.out.print((char) (c));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
