package general.task2v1;

import java.util.Arrays;
import java.util.Scanner;

public class Ticktacktoe {
    private static final char SIGN_X = 'X';
    private static final char SIGN_O = 'O';
    private final char[][] table = new char[3][3];;

    public void startGame() {
        fillTable();
        while (true) {
            printTable();
            doStep();
            printTable();
            if (isWinX()) {
                System.out.println("Вы Выйграли!");
                break;
            }
            doStepComputer();
            printTable();
            if (isWinO()) {
                System.out.println("Выйграл Компьютер!");
                break;
            }
        }
    }

    private void doStep() {
        Scanner scanner = new Scanner(System.in);
        printTable();
        System.out.println("Ваш ход. Введите координаты своей метки № строки и № стобца");
        int y;
        int x;
        while (true) {
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
            if (table[x][y] == '.') {
                table[x][y] = SIGN_X;
                break;
            } else {
                System.out.println("Ячейка занята. Введите еще раз координаты");
            }
        }
    }

    private void doStepComputer() {
        System.out.println("Ход компьютера.");
        int y;
        int X;
        while (true) {
            X = (int) (Math.random() * 3);
            y = (int) (Math.random() * 3);
            if (table[X][y] == '.') {
                table[X][y] = SIGN_O;
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
        for (char[] chars : table) {
            Arrays.fill(chars, '.');
        }
    }

    private void printTable() {
        for (char[] chars : table) {
            for (char aChar : chars) {
                System.out.println(aChar + " ");
            }
            System.out.println();
        }
    }

}
