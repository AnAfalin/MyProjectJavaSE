package general.task2v2;

import java.util.Arrays;
import java.util.Scanner;

public class Ticktacktoe {
    private static final char SIGN_X = 'X';
    private static final char SIGN_O = 'O';
    private static final int WEIGHT = 3;
    private static final int HEIGHT = 3;
    private final char[][] table = new char[WEIGHT][HEIGHT];


    public void startGame() {
        fillTable();
        while (true) {
            doStep();
            if (isWinX()) {
                System.out.println("Вы Выиграли!");
                break;
            }
            doStepComputer();
            if (isWinO()) {
                System.out.println("Выиграл Компьютер!");
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
            if (table[y][x] == '.') {
                table[y][x] = SIGN_X;
                break;
            } else {
                System.out.println("Ячейка занята. Введите еще раз координаты");
            }
        }
    }

    private void doStepComputer() {
        printTable();
        System.out.println("Ход компьютера.");
        switch (checkComputerWin()) {
            case 1: table[0][0] = SIGN_O; break;
            case 2: table[0][1] = SIGN_O; break;
            case 3: table[0][2] = SIGN_O; break;
            case 4: table[1][0] = SIGN_O; break;
            case 5: table[1][1] = SIGN_O; break;
            case 6: table[1][2] = SIGN_O; break;
            case 7: table[2][0] = SIGN_O; break;
            case 8: table[2][1] = SIGN_O; break;
            case 9: table[2][2] = SIGN_O; break;
            default: switch (checkUserWin()) {
                case 1: table[0][0] = SIGN_O; break;
                case 2: table[0][1] = SIGN_O; break;
                case 3: table[0][2] = SIGN_O; break;
                case 4: table[1][0] = SIGN_O; break;
                case 5: table[1][1] = SIGN_O; break;
                case 6: table[1][2] = SIGN_O; break;
                case 7: table[2][0] = SIGN_O; break;
                case 8: table[2][1] = SIGN_O; break;
                case 9: table[2][2] = SIGN_O; break;
                default: {
                    int x = 0;
                    int y = 0;
                    while (true) {
                        x = (int) (Math.random() * 3);
                        y = (int) (Math.random() * 3);
                        if (table[x][y] == '.') {
                            table[x][y] = SIGN_O;
                            break;
                        }
                    }
                }
                }
            }
        }

    private int checkComputerWin() {
        for (int i = 0; i < table.length; i++) {
            int countO = 0;
            for (int j = 0; j < table[i].length; j++) {
                if (table[i][j] == 'O') {
                    countO++;
                }
            }
            if (countO == 2) {
                return findEmptyCellInRow(i);
            }
        }
        for (int i = 0; i < table.length; i++) {
            int countO = 0;
            for (int j = i; j < table.length; j++) {
                if (table[j][i] == 'O') {
                    countO++;
                }
            }
            if (countO == 2) {
                return findEmptyCellInColumn(i);
            }
        }
        int countOd = 0;
        for (int i = 0; i < table.length; i++) {

            if (table[i][i] == 'O') {
                countOd++;
            }
            if (countOd == 2) {
                return findEmptyCellInDiagonalFirst();
            }
        }
        countOd = 0;
        for (int i = 0; i < table.length; i++) {
            if (table[i][table.length - 1 - i] == 'O') {
                countOd++;
            }
            if (countOd == 2) {
                return findEmptyCellInDiagonalSecond();
            }
        }
        return -1;
    }

    private int checkUserWin() {
        for (int i = 0; i < table.length; i++) {
            int countX = 0;
            for (int j = 0; j < table[i].length; j++) {
                if (table[i][j] == 'O') {
                    countX++;
                }
            }
            if (countX == 2) {
                return findEmptyCellInRow(i);
            }
        }
        for (int i = 0; i < table.length; i++) {
            int countX = 0;
            for (int j = i; j < table.length; j++) {
                if (table[j][i] == 'O') {
                    countX++;
                }
            }
            if (countX == 2) {
                return findEmptyCellInColumn(i);
            }
        }
        int countXd = 0;
        for (int i = 0; i < table.length; i++) {

            if (table[i][i] == 'O') {
                countXd++;
            }
            if (countXd == 2) {
                return findEmptyCellInDiagonalFirst();
            }
        }
        countXd = 0;
        for (int i = 0; i < table.length; i++) {
            if (table[i][table.length - 1 - i] == 'O') {
                countXd++;
            }
            if (countXd == 2) {
                return findEmptyCellInDiagonalSecond();
            }
        }
        return -1;
    }

    private int findEmptyCellInColumn(int column) {
        for (int i = 0; i < table.length; i++) {
            if (table[i][column] == '.') {
                return i * 3 + column + 1;
            }
        }
        return -1;
    }

    private int findEmptyCellInRow(int row) {
        for (int j = 0; j < table[row].length; j++) {
            if (table[row][j] == '.') {
                return row * 3 + j + 1;
            }
        }
        return -1;
    }

    private int findEmptyCellInDiagonalFirst() {
        if (table[0][0] == '.') return 1;
        else if (table[1][1] == '.') return 5;
        else return 9;
    }

    private int findEmptyCellInDiagonalSecond() {
        if (table[0][2] == '.') return 3;
        else if (table[1][1] == '.') return 5;
        else return 7;
    }


    private boolean isWin(char sign) {
        //проверка по горизонтали
        for (int i = 0; i < 2; i++) {
            if (table[i][0] == sign && table[i][1] == sign && table[i][2] == sign) {
                return true;
            }
        }
        //проверка по вертикали
        for (int j = 0; j < 2; j++) {
            if (table[0][j] == sign && table[1][j] == sign && table[2][j] == sign) {
                return true;
            }
        }
        //проверка по диагоналям
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
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }

}

class MainGame{
    public static void main(String[] args) {
        new Ticktacktoe().startGame();
    }
}
