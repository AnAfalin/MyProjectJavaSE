package general.task1;


import java.util.Scanner;


public class Ticktacktoe {
    private static final char SIGN_X = 'x';
    private static final char SIGN_O = 'o';
    private char[][] table;


    public Ticktacktoe() {
        table = new char[3][3];
    }

    public void startGame() {
        fillTable();
        while (true) {
            doStepFirst();
            if (isWinX()) {
                System.out.println("Выйграл Х!");
                break;
            }
            doStepSecond();
            if (isWinO()) {
                System.out.println("Выйграл О!");
                break;
            }
        }
    }

    private void doStepFirst() {
        doStep(SIGN_X);
    }

    private void doStepSecond() {
        doStep(SIGN_O);
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

    private void doStep(char sign) {
        Scanner scanner = new Scanner(System.in);
        printTable();
        System.out.println("Введите координаты своей метки № строки и № стобца");
        int j;
        int i;
        while (true) {
//            String input = scanner.next();
//            i = Character.getNumericValue(input.charAt(0)) - 1;
//            j = Character.getNumericValue(input.charAt(1)) - 1;
            i = scanner.nextInt() - 1;
            j = scanner.nextInt() - 1;
            if (table[i][j] == '.') {
                table[i][j] = sign;
                break;
            } else {
                System.out.println("Ячейка занята. Введите еще раз координаты");
            }
        }
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
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }

}
