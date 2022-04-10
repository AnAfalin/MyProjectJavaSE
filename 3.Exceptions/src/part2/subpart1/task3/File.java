package part2.subpart1.task3;

import java.io.FileWriter;
import java.io.IOException;

public class File extends AbstractFile{
    @Override
    public FileWriter createFileWriter() {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("text.txt");
            return fileWriter;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
