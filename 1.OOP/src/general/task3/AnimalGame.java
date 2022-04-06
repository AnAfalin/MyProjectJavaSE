package general.task3;

import java.util.Arrays;

public class AnimalGame {
    private static final int WEIGHT = 25;
    private static final int HEIGHT = 25;
    private char[][] field = new char[WEIGHT][HEIGHT];


    //заполнения поля ячейками
    private void fillField(){
        for (char[] chars : field) {
            Arrays.fill(chars, '.');
        }
    }

    //вывод поля на консоль
    private void printField(){
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.println(field[i][j] + " ");
            }
            System.out.println();
        }
    }
}
