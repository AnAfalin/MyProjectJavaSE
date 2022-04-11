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
            printTable();
            if (isWinX()) {
                System.out.println("Вы Выиграли!");
                break;
            }
            doStepComputer();
            printTable();
            if (isWinO()) {
                System.out.println("Выиграл Компьютер!");
                break;
            }

        }
    }

    private void doStep() {
        Scanner scanner = new Scanner(System.in);
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
        if(checkUserWin() != -1){
            int res = checkUserWin() - 1;
            int y = res / 3;  //2
            int x = res - y * 3;
            table[x][y] = SIGN_O;
        }else if(checkComputerWin() != -1) {
            int result = checkComputerWin() - 1;
            int y = result / 3;  //2
            int x = result - y * 3;
            table[x][y] = SIGN_O;
        }else {
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

    private int checkComputerWin() {
        return checkWin(SIGN_O);
    }

    private int checkUserWin() {
        return checkWin(SIGN_X);
    }

    private int checkWin(char sign) {
        int res = 0;
        res = checkDiagonalFirstWin(sign);
        if(res == -1) {
            res = checkDiagonalSecondWin(sign);
            if (res == -1) {
                res = checkRowWin(sign);
                if (res == -1) {
                    res = checkColumnWin(sign);
                }
            }
        }
        return res;

    }
    private int checkRowWin(char sign) {
        for (int i = 0; i < table.length; i++) {
            int countX = 0;
            for (int j = 0; j < table[i].length; j++) {
                if (table[i][j] == sign) {
                    countX++;
                }
            }
            if (countX == 2) {
                return findEmptyCellInRow(i);
            }
        }
        return -1;
    }
    private int checkColumnWin(char sign) {
        for (int i = 0; i < table.length; i++) {
            int countX = 0;
            for (int j = i; j < table.length; j++) {
                if (table[j][i] == sign) {
                    countX++;
                }
            }
            if (countX == 2) {
                return findEmptyCellInColumn(i);
            }
        }
        return -1;
    }
    private int checkDiagonalFirstWin(char sign) {
        int countXd = 0;
        for (int i = 0; i < table.length; i++) {

            if (table[i][i] == sign) {
                countXd++;
            }
            if (countXd == 2) {
                return findEmptyCellInDiagonalFirst();
            }
        }
        return -1;
    }
    private int checkDiagonalSecondWin(char sign){
        int countXd = 0;
        for (int i = 0; i < table.length; i++) {
            if (table[table.length - 1 - i][i] == sign) {
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
        if (table[0][0] == '.') {
            return 1;
        }
        else if (table[1][1] == '.') {
            return 5;
        }
        else if (table[2][1] == '.') {
            return 9;
        }
        return -1;
    }

    private int findEmptyCellInDiagonalSecond() {
        if (table[0][2] == '.') {
            return 3;
        }
        else if (table[1][1] == '.') {
            return 5;
        }
        else if(table[2][0] == '.'){
            return 7;
        }
        return -1;
    }


    private boolean isWin(char sign) {
        //проверка по горизонтали
        for (int i = 0; i < 3; i++) {
            if (table[i][0] == sign && table[i][1] == sign && table[i][2] == sign) {
                return true;
            }
        }
        //проверка по вертикали
        for (int j = 0; j < 3; j++) {
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
        printTable();
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
