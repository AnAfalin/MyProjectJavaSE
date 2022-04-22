package general.task3.players;

public abstract class Animal {
    public int stepRange; //область действия животного
    public int stepWithoutMeal; //количество ходов без еды
    public char sign;//обозначение
    int x;
    int y;

    public Animal() {
        stepRange = 2;
        stepWithoutMeal = 0;
    }

    public char getSign() {
        return sign;
    }

    public void setXY(int i, int j){
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
