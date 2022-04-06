package general.test;

public class Game {
    private char[][] table;

    public Game() {
        table = new char[][]{
                {'.', '.', '.'},
                {'.', 'O', '.'},
                {'O', '.', '.'}};
    }

    public int checkComputerWin() {
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

    public static void main(String[] args) {
        System.out.println(new Game().checkComputerWin());


    }
}
