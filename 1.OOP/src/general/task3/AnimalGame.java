package general.task3;

import java.util.Random;

public class AnimalGame {
    private static final int WEIGHT = 10;
    private static final int HEIGHT = 10;
    private static final int VOLUME_ANIMAL = 1;
    private static final int VOLUME_FOOD = 2;
    private final Object[][] field = new Object[WEIGHT][HEIGHT];
    private static final String LINE_SEPARATOR = "-";
    private static final Random random = new Random();
    private Animal[] arrayPlayers = new Animal[WEIGHT * HEIGHT];
    private int size;


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

    //стартовое заполнение игрового поля
    private void firstFillField() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = ".";
            }
        }
        addElementsOnField();
        printField();
        System.out.println(LINE_SEPARATOR.repeat(98));
    }

    public void startGame() {
        firstFillField();
        while (true) {
            for (int i = 0; i < size; i++) {
                oneStep(arrayPlayers[i]);
            }
            printField();
            randomAddFoodOnField();
            printField();
        }
    }

    //добавление элементов на поле
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

    private void randomAddFoodOnField() {
        int volume = random.nextInt(5) + 1;
        for (int i = 0; i < volume; i++) {
            addFoodOnField(new Meal());
            addFoodOnField(new Grass());
        }
    }

    //добавление животных на поле
    private void addAnimalOnField(Animal animal) {
        int i, j; //координаты
        while (true) {
            i = random.nextInt(WEIGHT);
            j = random.nextInt(HEIGHT);
            if (checkCellIsEmpty(i, j)) {
                field[i][j] = animal.getSign();
                animal.setXY(i, j);
                addAnimalInArrayPlayers(animal);
                break;
            }
        }
    }

    //добавление еды на поле
    private void addFoodOnField(Food food) {
        int i, j; //координаты
        while (true) {
            i = random.nextInt(WEIGHT);
            j = random.nextInt(HEIGHT);
            if (checkCellIsEmpty(i, j)) {
                field[i][j] = food.getSign();
                break;
            }
        }
    }

    //проверка что клетка не занята животным или едой
    private boolean checkCellIsEmpty(int i, int j) {
        return field[i][j].equals(".");
    }

    //добавление животных в массив животных
    private void addAnimalInArrayPlayers(Animal animal) {
        arrayPlayers[size] = animal;
        size++;
    }

    public void oneStep(Animal animal) {
        int j = animal.getX();
        int i = animal.getY();
        if (animal instanceof Predator) {
            boolean isNecessaryRandom = true;
            int minI, minJ, maxI, maxJ;
            minI = Math.max(i - 2, 0);
            minJ = Math.max(j - 2, 0);
            maxI = Math.min(i + 2, HEIGHT);
            maxJ = Math.min(j + 2, WEIGHT);
            for (int y = minI; y < maxI; y++) {
                for (int x = minJ; x < maxJ; x++) {
                    if (field[y][x].equals('X')) {
                        //съедается травоядный
                        field[y][x] = animal.getSign();
                        field[i][j] = '.';
                        animal.setXY(y,x);
                        isNecessaryRandom = false;
                        break;
                    } else if (field[y][x].equals('m')) {
                        field[y][x] = animal.getSign();
                        field[i][j] = '.';
                        animal.setXY(y,x);
                        isNecessaryRandom = false;
                        break;
                    }
                }
            }
            if (isNecessaryRandom) {
                while (true) {
                    int newI = random.nextInt(minI, maxI);
                    int newJ = random.nextInt(minJ, maxJ);
                    if (checkCellIsEmpty(newI, newJ)) {
                        field[newI][newJ] = animal.getSign();
                        field[i][j] = '.';
                        animal.stepWithoutMeal++;
                        break;
                    }
                }
            }
        }
        if (animal instanceof Herbivore) {
            boolean isNecessaryRandom = true;
            int minI, minJ, maxI, maxJ;
            minI = Math.max(i - 2, 0);
            minJ = Math.max(j - 2, 0);
            maxI = Math.min(i + 2, HEIGHT);
            maxJ = Math.min(j + 2, WEIGHT);
            for (int y = minI; y < maxI; y++) {
                for (int x = minJ; x < maxJ; x++) {
                    if (field[y][x].equals('g')) {
                        field[y][x] = animal.getSign();
                        field[i][j] = '.';
                        isNecessaryRandom = false;
                        break;
                    }
                }
            }
            if (isNecessaryRandom) {
                while (true) {
                    int newI = random.nextInt(minI, maxI);
                    int newJ = random.nextInt(minJ, maxJ);
                    if (checkCellIsEmpty(newI, newJ)) {
                        field[newI][newJ] = animal.getSign();
                        field[i][j] = '.';
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        AnimalGame game = new AnimalGame();
        game.startGame();
        game.printField();

    }
}
