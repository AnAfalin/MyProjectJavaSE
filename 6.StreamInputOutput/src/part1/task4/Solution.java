package part1.task4;

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String str = "This string is text of task4";
        try (FileWriter fw = new FileWriter("6.StreamInputOutput/src/part1/task4/Task4.txt");
             FileReader fr = new FileReader("6.StreamInputOutput/src/part1/task4/Task4.txt");
             BufferedWriter bw = new BufferedWriter(fw);
             BufferedReader br = new BufferedReader(fr)) {

                bw.write(str);

            int c;
            while ((c = br.read()) != -1){
                System.out.print((char)(c));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
