package infoTest;

import java.io.*;
import java.util.Random;

public class ByteStream {
    public static void main(String[] args) {
        OutputStream outPut = null;
        try {
            outPut = new FileOutputStream("File.txt");
            outPut.write("100".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outPut != null) {
                try {
                    outPut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        //созданный поток можно использовать только внутри блока try-с-ресурсами.
        String text = "text";
        try (OutputStream outPut1 = new FileOutputStream("File1.txt")) {
            byte[] textArray = text.getBytes();
            outPut1.write(textArray);   //Запись текста (String) в файл с помощью байтового потока
        } catch (IOException ex) {
            ex.printStackTrace();
        }


//        try (InputStream inPut = new FileInputStream("File.txt")){
//            int c;      //int c – целочисленное представление байта.
//            while ((c = inPut.read()) != -1){
//                System.out.print(c);
//            }
        try (InputStream inPut = new FileInputStream("File1.txt")) {
            int c;      //int c – целочисленное представление байта.
            while ((c = inPut.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            System.out.println();

        }


        //DataOutputStream – записывает в файл примитивы.
        //Для этого используются аналогичные методы (writeInt, writeByte, writeBoolean, writeUTF – для строк, writeDouble)
        Random random = new Random();
        try (FileOutputStream fileOutputStream = new FileOutputStream("OutputStream.txt");
             DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream)) {

            for (int i = 0; i < 10; i++) {
                dataOutputStream.writeInt(random.nextInt(10));
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try (FileInputStream fileInputStream = new FileInputStream("OutputStream.txt");
             DataInputStream dataInputStream = new DataInputStream(fileInputStream)) {
            for (int i = 0; i < 10; i++) {
                int n = dataInputStream.readInt();
                System.out.println(n + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        //При создании буферизированного потока в конструктор необходимо передать побайтовый поток (любой)
        //Буферизированный поток добавит специальный буфер для временного хранения при записи и чтении байтов.
        //Такой подход увеличивает эффективность операций чтения и записи.
        text = "Hello My Dear";
        try (FileOutputStream fileOutputStream = new FileOutputStream("BufferedOutputStream.txt");
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream)) {
            bufferedOutputStream.write(text.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fileInputStream = new FileInputStream("BufferedOutputStream.txt");
             BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream)) {
            int c;
            while ((c = bufferedInputStream.read()) != -1){
                System.out.print((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println();
        }




    }
}

