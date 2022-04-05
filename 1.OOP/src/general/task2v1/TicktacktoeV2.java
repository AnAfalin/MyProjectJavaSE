package general.task2v1;


import java.util.Scanner;

import static java.lang.System.*;
import static java.lang.System.out;

public class TicktacktoeV2 {
    private static final char SIGN_X = 'x';
    private static final char SIGN_O = 'o';
    private final char[][] table = new char[3][3];;

    public void startGame() {
        fillTable();
        while (true) {
            doStep();
            if (isWinX()) {
                out.println("Вы Выйграли!");
                break;
            }
            doStepComputer();
            if (isWinO()) {
                out.println("Выйграл Компьютер!");
                break;
            }
        }
    }

    private void doStep() {
        Scanner scanner = new Scanner(in);
        printTable();
        out.println("Ваш ход. Введите координаты своей метки № строки и № стобца");
        int j;
        int i;
        while (true) {
            i = scanner.nextInt() - 1;
            j = scanner.nextInt() - 1;
            if (table[i][j] == '.') {
                table[i][j] = SIGN_X;
                break;
            } else {
                out.println("Ячейка занята. Введите еще раз координаты");
            }
        }
    }

    private void doStepComputer() {
        out.println("Ход компьютера...");
        int j;
        int i;
        while (true) {
            i = (int) (Math.random() * 3);
            j = (int) (Math.random() * 3);
            if (table[i][j] == '.') {
                table[i][j] = SIGN_O;
                break;
            }
        }
    }

    private boolean isWin(char sign) {
        for (int i = 0; i < 2; i++) {//проверка по горизонтали
            if (table[i][0] == sign && table[i][1] == sign && table[i][2] == sign) {
                return true;
            }
        }
        for (int j = 0; j < 2; j++) {//проверка по вертикали
            if (table[0][j] == sign && table[1][j] == sign && table[2][j] == sign) {
                return true;
            }
        }
        if (table[0][0] == sign && table[1][1] == sign && table[2][2] == sign) {
            return true;
        }
        if (table[0][2] == sign && table[1][1] == sign && table[2][0] == sign) {
            return true;
        }
        return false;

    }

    private boolean isWinX() {
        return isWin(SIGN_X);
    }

    private boolean isWinO() {
        return isWin(SIGN_O);
    }

    private void fillTable() {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = '.';
            }
        }
    }

    private void printTable() {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                out.print(table[i][j] + " ");
            }
            out.println();
        }
    }

}
