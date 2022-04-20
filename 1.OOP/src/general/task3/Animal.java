package general.task3;

public abstract class Animal {
    int stepRange; //область действия животного
    int stepWithoutMeal; //количество ходов без еды
    char sign;//обозначение
    int x;
    int y;



    public Animal() {
        stepRange = 1;
        stepWithoutMeal = 0;
    }

    public char getSign() {
        return sign;
    }

    public void setXY(int i, int j) {
        this.y = i;
        this.x = j;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
