package infoTest;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileStream {
    public static void main(String[] args) {
        String text = "This is a text";
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("RandomAccessFile.txt", "rw")){
            randomAccessFile.write(text.getBytes());

            //Для того чтобы записать в файл, а потом сразу же читать его, необходимо переместить курсор файла (номер байта в файле) на 0 (на начало файла)
            randomAccessFile.seek(0);
            int c;
            while ((c = randomAccessFile.read()) != -1){
                System.out.print((char) c);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println();
        }

        try (RandomAccessFile randomAccessFile = new RandomAccessFile("RandomAccessFile.txt", "rw")){

            int c;
            while ((c = randomAccessFile.read()) != -1){
                System.out.print((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println();
        }

        String text1 = "T e x t   w i t h   a   l o t s   o f   s p e a c e s !";
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("RandomAccessFile1.txt", "rw")){
            randomAccessFile.write(text1.getBytes());

            randomAccessFile.seek(0);
            int c;
            while ((c = randomAccessFile.read()) != -1){
                randomAccessFile.skipBytes(1);
                System.out.print((char) c);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
