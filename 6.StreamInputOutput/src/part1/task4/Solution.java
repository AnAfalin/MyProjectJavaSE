package part1.task4;

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        String str = "This string is text of task4";
        try (FileWriter fw = new FileWriter("Task4.txt")) {
            try(BufferedWriter bw = new BufferedWriter(fw)){
                bw.write(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileReader fr = new FileReader("Task4.txt")){
            try (BufferedReader br = new BufferedReader(fr)) {
                int c;
                while ((c = br.read()) != -1){
                    System.out.print((char)(c));
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
