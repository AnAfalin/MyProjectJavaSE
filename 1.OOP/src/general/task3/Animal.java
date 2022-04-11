package general.task3;

public abstract class Animal {
    int stepRange; //область действия животного
    int stepWithoutMeal; //количество ходов без еды
    char sign;//обозначение

    abstract void move();

    public Animal() {
        stepRange = 2;
        stepWithoutMeal = 5;
    }

    public char getSign() {
        return sign;
    }
}
