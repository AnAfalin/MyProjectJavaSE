package general.task3.game;

import general.task3.objgame.Food;
import general.task3.objgame.Grass;
import general.task3.objgame.Meal;
import general.task3.players.Animal;
import general.task3.players.Herbivore;
import general.task3.players.Predator;

import java.util.Random;

public class AnimalGame {
    private static final int WEIGHT = 25;
    private static final int HEIGHT = 25;
    private static final int VOLUME_ANIMAL = 3;
    private static final int VOLUME_FOOD = 5;
    private final String[][] field = new String[WEIGHT][HEIGHT];
    private static final String LINE_SEPARATOR = "-";
    private static final Random random = new Random();
    private Animal[] arrayPlayers = new Animal[WEIGHT * HEIGHT];
    private int size;
    private static final int COUNT_WITHOUT_MEAL = 3;

    //метод хода игры
    public void startGame() {
        firstFillField();
        while (true) {
            for (int i = 0; i < arrayPlayers.length; i++) {
                if (arrayPlayers[i] != null) {
                    oneStep(arrayPlayers[i], i);
                }
            }
            randomAddFoodOnField();
            printField();
            //printInfoGame();
            if (isWin()){
                printInfoGameOver();
                break;
            }
        }

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

    //добавление еды на поле
    private void randomAddFoodOnField() {
        int volume = random.nextInt(VOLUME_FOOD) + 1;
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
                field[i][j] = String.valueOf(animal.getSign());
                animal.setXY(i, j);
                addAnimalInArrayPlayers(animal);
                break;
            }
        }
    }

    //добавление животных в массив животных
    private void addAnimalInArrayPlayers(Animal animal) {
        for (int i = 0; i < arrayPlayers.length; i++) {
            if(arrayPlayers[i] == null){
                arrayPlayers[i] = animal;
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
                field[i][j] = String.valueOf(food.getSign());
                break;
            }
        }
    }

    //проверка что клетка не занята животным или едой
    private boolean checkCellIsEmpty(int i, int j) {
        return field[i][j].equals(".");
    }


    public void oneStep(Animal animal, int index) {
        int i = animal.getY();
        int j = animal.getX();
        int minI, minJ, maxI, maxJ;
        minI = Math.max(i - animal.stepRange, 0);
        minJ = Math.max(j - animal.stepRange, 0);
        maxI = Math.min(i + animal.stepRange, HEIGHT-1);
        maxJ = Math.min(j + animal.stepRange, WEIGHT-1);
        if (animal instanceof Predator) {
            boolean isNecessaryRandom = true;

            boolean isContinue = true;
            for (int y = minI; y <= maxI && isContinue; y++) {
                for (int x = minJ; x <= maxJ && isContinue; x++) {
                    if (field[y][x].equals("X")) {
                        killAnimal(y, x); //съедается травоядный
                        field[y][x] = String.valueOf(animal.getSign());
                        field[i][j] = ".";
                        animal.setXY(y, x);
                        animal.stepWithoutMeal = 0;
                        addRandomNewAnimal(animal);
                        isNecessaryRandom = false;
                        isContinue = false;
                    } else if (field[y][x].equals("m")) {
                        field[y][x] = String.valueOf(animal.getSign());
                        field[i][j] = ".";
                        addRandomNewAnimal(animal);
                        animal.setXY(y, x);
                        animal.stepWithoutMeal = 0;
                        isNecessaryRandom = false;
                        isContinue = false;
                    }
                }
            }
            if (isNecessaryRandom) {
                while (true) {
                    if (animal.stepWithoutMeal + 1 > COUNT_WITHOUT_MEAL) {
                        field[i][j] = ".";;
                        arrayPlayers[index] = null;
                        break;
                    }
                    int newI = random.nextInt(minI, maxI+1);
                    int newJ = random.nextInt(minJ, maxJ+1);
                    if (checkCellIsEmpty(newI, newJ)) {
                        field[newI][newJ] = String.valueOf(animal.getSign());
                        animal.setXY(newI, newJ);
                        field[i][j] = ".";
                        animal.stepWithoutMeal++;
                        break;
                    }
                }
            }
        }
        if (animal instanceof Herbivore) {
            boolean isNecessaryRandom = true;
            boolean isContinue = true;
            for (int y = minI; y <= maxI && isContinue; y++) {
                for (int x = minJ; x <= maxJ && isContinue; x++) {
                    if (field[y][x].equals("g")) {
                        field[y][x] = String.valueOf(animal.getSign());
                        field[i][j] = ".";
                        animal.setXY(y, x);
                        animal.stepWithoutMeal = 0;
                        addRandomNewAnimal(animal);
                        isNecessaryRandom = false;
                        isContinue = false;
                    }
                }
            }
            if (isNecessaryRandom) {
                while (true) {
                    if (animal.stepWithoutMeal + 1 > COUNT_WITHOUT_MEAL) {
                        field[i][j] = ".";
                        arrayPlayers[index] = null;
                        break;
                    }
                    int newI = random.nextInt(minI, maxI);
                    int newJ = random.nextInt(minJ, maxJ);
                    if (checkCellIsEmpty(newI, newJ)) {
                        field[newI][newJ] = String.valueOf(animal.getSign());
                        field[i][j] = ".";
                        animal.stepWithoutMeal++;
                        animal.setXY(newI, newJ);
                        break;
                    }
                }
            }
        }
    }

    private void killAnimal(int i, int j) {
        for (int y = 0; y < arrayPlayers.length; y++) {
            if(arrayPlayers[i] != null) {
                if (arrayPlayers[i].getX() == j && arrayPlayers[i].getY() == i) {
                    arrayPlayers[i] = null;
                    field[i][j] = ".";
                    break;
                }
            }
        }
    }

    private boolean isWin(){
        int countPredator = countPredator();
        int countHerbivore = countHerbivore();
        System.out.println("В игре: Хищников " + countPredator + " Травоядных " + countHerbivore);
        return countHerbivore == 0 || countPredator == 0;
    }

    //метод размножения животного
    private void addRandomNewAnimal(Animal animal){
        Random random = new Random();
        if(random.nextInt(1,3) == 1){
            if (animal instanceof Predator) {
                addAnimalOnField(new Predator());
            }else if(animal instanceof Herbivore){
                addAnimalOnField(new Herbivore());
            }
        }
    }

    private void printInfoGameOver(){
        int countPredator = countPredator();
        int countHerbivore = countHerbivore();
        if(countHerbivore == 0){
            System.out.println("В игре победили Хищники");
        }else if (countPredator == 0){
            System.out.println("В игре победили Травоядные");
        }
    }

    private int countPredator(){
        int countPredator = 0;
        for (Animal arrayPlayer : arrayPlayers) {
            if (arrayPlayer != null) {
                if (arrayPlayer instanceof Predator) {
                    countPredator++;
                }
            }
        }
        return countPredator;
    }

    private int countHerbivore(){
        int countHerbivore = 0;
        for (Animal arrayPlayer : arrayPlayers) {
            if (arrayPlayer != null) {
                if (arrayPlayer instanceof Herbivore) {
                    countHerbivore++;
                }
            }
        }
        return countHerbivore;
    }

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

}
