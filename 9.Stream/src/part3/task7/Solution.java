package part3.task7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {


        Path pathRes = Path.of("9.Stream/src/part3/task7/Result.txt");
        Files.createFile(pathRes);
        Files.walk(Path.of("9.Stream/src/part3/task7/Folder")).toList()
                .stream()
                .filter(file -> Files.isRegularFile(file))
                .forEach(path -> {
                    try {
                        List<String> list = Files.readAllLines(path);
                        Files.write(pathRes, list, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });


    }
}
