package part4.task6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {

        List<String> list = List.of("Java", "Pascal", "JavaScript", "Python", "Assembler", "Swift");
        try {
            Files.createFile(Path.of("6.StreamInputOutput/src/part4/task6/text.txt"));
            Files.write(Path.of("6.StreamInputOutput/src/part4/task6/text.txt"), list, StandardOpenOption.CREATE_NEW);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(Files.exists((Path.of("6.StreamInputOutput/src/part4/task6/text.txt")))){
                Files.delete(Path.of("6.StreamInputOutput/src/part4/task6/text.txt"));
            }
            Files.write(Path.of("6.StreamInputOutput/src/part4/task6/text.txt"), list);
        }


    }
}
