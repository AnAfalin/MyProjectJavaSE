package polymorphism.part1.task3;

public class ZooShop {

    public static void addAnimal(Animal animal){
        System.out.print("В магазине появилось животное - ");
        animal.info();
        animal.say();
    }


    public static void main(String[] args) {
        addAnimal(new Cat());
    }
}
