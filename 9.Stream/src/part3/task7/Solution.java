package part3.task7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;


public class Solution {
    public static void main(String[] args) throws IOException {


        Path pathRes = Path.of("9.Stream/src/part3/task7/Result.txt");
        Files.createFile(pathRes);
        String s = Files.walk(Path.of("9.Stream/src/part3/task7/Folder")).toList()
                .stream()
                .map(path -> path.toFile())
                .filter(file -> file.isFile())
                .map(file -> file.getPath())
                .map(str -> {
                    try {
                        return Files.readAllLines(Path.of(str));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })
                .flatMap(list -> list.stream())
                .collect(Collectors.joining());

        System.out.println(s);

        Files.writeString(pathRes, s);


    }
}
