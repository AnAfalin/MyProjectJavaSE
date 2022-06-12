package part4.task3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {

        List<String> list = List.of("June", "Java", "Summer", "Sea", "Sun");

        Files.write(Path.of("6.StreamInputOutput/src/part4/task3/file.txt"), list);

        //проверка - существует ли директория по данному пути
        //если существует, то файл удаляется
        if(!Files.exists(Path.of("6.StreamInputOutput/src/part4/task3/copy"))){
            Files.createDirectory(Path.of("6.StreamInputOutput/src/part4/task3/copy"));
        }

        //проверка - существуект ли файл по данному пути
        //если существует, то файл удаляется
        if(Files.exists(Path.of("6.StreamInputOutput/src/part4/task3/copy/copyfile.txt"))){
            Files.delete(Path.of("6.StreamInputOutput/src/part4/task3/copy/copyfile.txt"));
        }
        Files.copy(Path.of("6.StreamInputOutput/src/part4/task3/file.txt"), Path.of("6.StreamInputOutput/src/part4/task3/copy/copyfile.txt"));

        //проверка - существует ли директория по данному пути
        //если существует, то файл удаляется
        if(!Files.exists(Path.of("6.StreamInputOutput/src/part4/task3/move"))){
            Files.createDirectory(Path.of("6.StreamInputOutput/src/part4/task3/move"));
        }

        //проверка - существуект ли файл по данному пути
        //если существует, то файл удаляется
        if(Files.exists(Path.of("6.StreamInputOutput/src/part4/task3/move/file.txt"))){
            Files.delete(Path.of("6.StreamInputOutput/src/part4/task3/move/file.txt"));
        }
        Files.move(Path.of("6.StreamInputOutput/src/part4/task3/file.txt"), Path.of("6.StreamInputOutput/src/part4/task3/move/file.txt"));
    }
}
