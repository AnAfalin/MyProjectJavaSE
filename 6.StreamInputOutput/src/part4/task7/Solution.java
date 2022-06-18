package part4.task7;

import java.io.*;


public class Solution {
    public static void main(String[] args) throws IOException {
        String path = "6.StreamInputOutput/src/part4/task7/sourceFile.txt";
        RandomAccessFile randomAccessFile = new RandomAccessFile(path, "rw");

        int prevNum = Integer.parseInt(Character.toString((char) randomAccessFile.read()));
//        System.out.println("Предыдущее число " + prevNum);
        int currentNum;

        int lastNum = -1;
        int c;
        while ((c = randomAccessFile.read()) != -1) {
            lastNum = Integer.parseInt(Character.toString((char) c));
        }
//        System.out.println("Последнее число " + lastNum);


//        System.out.println("Положение курсора " + randomAccessFile.getFilePointer());
        randomAccessFile.seek(1);
//        System.out.println("Положение курсора " + randomAccessFile.getFilePointer());
        while ((c = randomAccessFile.read()) != -1) {
            currentNum = Integer.parseInt(Character.toString((char) c));
//            System.out.println(currentNum);
            if (currentNum - prevNum == 1) {
                prevNum = currentNum;
            } else {
                randomAccessFile.seek(randomAccessFile.getFilePointer() - 1);
                prevNum++;
                while (prevNum != lastNum) {
                    randomAccessFile.write(((Integer.toString(prevNum)).getBytes()));
                    prevNum++;
                }
                randomAccessFile.write(((Integer.toString(prevNum)).getBytes()));
                break;
            }
        }
    }
}
