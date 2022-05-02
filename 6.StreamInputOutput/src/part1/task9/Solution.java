package part1.task9;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        System.out.println("Дана матрица, которую считываем в файл\n");
        double[][] doubleMatrix = new double[5][5];
        for (int i = 0; i < doubleMatrix.length; i++) {
            for (int j = 0; j < doubleMatrix[i].length; j++) {
                doubleMatrix[i][j] = i*4 + j + i + 1;
                System.out.print(doubleMatrix[i][j] + " ");
            }
            System.out.println();
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("6.StreamInputOutput/src/part1/task9/doubleMatrix.txt"))){
            bufferedWriter.write("Ряд\tСтрока\tСреднее\n");
            int quantityElements = doubleMatrix.length * doubleMatrix[1].length;
            double sumAllElements = 0;

            for (int i = 0; i < doubleMatrix.length; i++) {
                double sumRowInRow = 0;

                for (int j = 0; j < doubleMatrix[i].length; j++) {
                    sumRowInRow += doubleMatrix[i][j];
                    sumAllElements += doubleMatrix[i][j];
                }
                double averageVolumeInRow = sumRowInRow / doubleMatrix[i].length;
                bufferedWriter.write(i+1 + "\t");
                bufferedWriter.write(sumRowInRow + "\t" + averageVolumeInRow + "\n");
            }
            double averageAllElements = sumAllElements / quantityElements;
            bufferedWriter.write("\n");
            bufferedWriter.write("Количество элементов:\t" + quantityElements + "\n");
            bufferedWriter.write("Сумма элементов:\t" + sumAllElements + "\n");
            bufferedWriter.write("Среднее всех элементов:\t" + averageAllElements + "\n");

            System.out.println("\nСчитали матрицу в файл");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
