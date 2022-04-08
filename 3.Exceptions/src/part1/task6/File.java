package part1.task6;

import java.io.IOException;

public class File{
    String fileName;

    public File(String fileName) {
    }

    public static File create(String fileName) throws IOException {
        return new File(fileName);
    }

//способ 1
//    public static void main(String[] args) throws IOException {
//        File file1 = File.create("name.txt");
//    }

//способ 2
    public static void main(String[] args) {
        try {
            File file1 = File.create("name.txt");
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

}


