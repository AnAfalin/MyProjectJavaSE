package infoTest;

import java.io.*;

public class CharStream {
    public static void main(String[] args) {
        String text = "This is a very important text";
        try (FileWriter fileWriter = new FileWriter("FileWriter.txt")) {
            fileWriter.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //По умолчанию данные файла затираются, если повторно открыть его с помощью байтового или символьного потока.
        //Чтобы данные не затирались, а добавлялись в конец, необходимо использовать конструктор,
        //принимающий булевское значение APPEND, указывающее необходимость добавлять в конец файла, а не затирать данные
        try (FileWriter fileWriter1 = new FileWriter("FileWriter.txt", true)) {
            fileWriter1.write("\nYes,Yes");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileReader fileReader = new FileReader("FileWriter.txt")) {
            int c;
            while ((c = fileReader.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println();
        }




        try (FileWriter fileWriter = new FileWriter("BufferedWriterReader.txt");
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileReader fileReader = new FileReader("BufferedWriterReader.txt");
             BufferedReader bufferedReader = new BufferedReader(fileReader)){
            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                System.out.print(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            System.out.println();
        }
    }
}
