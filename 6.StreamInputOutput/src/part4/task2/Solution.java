package part4.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) throws IOException {

        List<String> list = List.of("June", "Java", "Summer", "Sea", "Sun");

        Files.write(Path.of("6.StreamInputOutput/src/part4/task2/file.txt"), list);

        if(!Files.exists(Path.of("6.StreamInputOutput/src/part4/task2/copy"))){
            Files.createDirectory(Path.of("6.StreamInputOutput/src/part4/task2/copy"));
        }

        Files.copy(Path.of("6.StreamInputOutput/src/part4/task2/file.txt"), Path.of("6.StreamInputOutput/src/part4/task2/copy/file.txt"), StandardCopyOption.REPLACE_EXISTING);

        if(!Files.exists(Path.of("6.StreamInputOutput/src/part4/task2/move"))){
            Files.createDirectory(Path.of("6.StreamInputOutput/src/part4/task2/move"));
        }

        Files.move(Path.of("6.StreamInputOutput/src/part4/task2/file.txt"), Path.of("6.StreamInputOutput/src/part4/task2/move/file.txt"), StandardCopyOption.REPLACE_EXISTING);


    }
}
