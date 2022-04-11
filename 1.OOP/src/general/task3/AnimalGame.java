package general.task3;

import java.util.Random;

public class AnimalGame {
    private static final int WEIGHT = 25;
    private static final int HEIGHT = 25;
    private static final int VOLUME_ANIMAL = 5;
    private static final int VOLUME_FOOD = 10;
    private Object[][] field = new Object[WEIGHT][HEIGHT];
    private static final String LINE_SEPARATOR = "-";
    private static final Random random = new Random();


    //вывод поля на консоль
    private void printField() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j] + "   ");
            }
            System.out.println();
        }
        System.out.println(LINE_SEPARATOR.repeat(98));
    }

    private void firstFillField() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = ".";
            }
        }
        addElementsOnField();
        System.out.println(LINE_SEPARATOR.repeat(98));
    }

    public void startGame() {
        firstFillField();



    }


    private void addElementsOnField() {
        for (int i = 0; i < VOLUME_ANIMAL; i++) {
            addAnimalOnField(new Predator());
            addAnimalOnField(new Herbivore());
        }
        for (int i = 0; i < VOLUME_FOOD; i++) {
            addFoodOnField(new Meal());
            addFoodOnField(new Grass());
        }
    }

    private void addAnimalOnField(Animal animal) {
        int x, y; //координаты
        while (true){
            x = random.nextInt(25);
            y = random.nextInt(25);
            if (checkCellIsEmpty(x, y)) {
                field[x][y] = animal.getSign();
                break;
            }
        }
    }

    private void addFoodOnField(Food food) {
        int x, y; //координаты
        while (true){
            x = random.nextInt(25);
            y = random.nextInt(25);
            if (checkCellIsEmpty(x, y)) {
                field[x][y] = food.getSign();
                break;
            }
        }
    }

    private boolean checkCellIsEmpty(int x, int y){
        return field[x][y].equals(".");
    }

    public void oneStep(Animal animal) {
        animal.move();
    }


    public static void main(String[] args) {
        AnimalGame game = new AnimalGame();
        game.startGame();
        game.printField();

    }
}
