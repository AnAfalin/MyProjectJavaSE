package part4.task5;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        //запись с помощью потоков ввода-вывода
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("6.StreamInputOutput/src/part4/task5/text.txt"))){
            Scanner scanner = new Scanner(System.in);
            bufferedWriter.write(scanner.nextLine() + "\n");
            bufferedWriter.write(scanner.nextLine() + "\n");
        }catch (IOException e){
            e.printStackTrace();
        }

        //запись с помощтю класса Files
        if(!Files.exists(Path.of("6.StreamInputOutput/src/part4/task5/text.txt"))) {
            Files.createFile(Path.of("6.StreamInputOutput/src/part4/task5/text.txt"));
        }
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine() + "\n";
        String s2 = scanner.nextLine() + "\n";
        Files.writeString(Path.of("6.StreamInputOutput/src/part4/task5/text.txt"), s1, StandardOpenOption.APPEND);
        Files.writeString(Path.of("6.StreamInputOutput/src/part4/task5/text.txt"), s2, StandardOpenOption.APPEND);

    }
}
