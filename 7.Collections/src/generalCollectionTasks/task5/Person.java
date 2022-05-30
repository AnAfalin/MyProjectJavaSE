package generalCollectionTasks.task5;

import java.util.Comparator;

public class Person {
    private int age;
    public int countProduct;    //количество продуктов
    public int number;

    public Person(int age, int countProduct, int number) {
        this.age = age;
        this.countProduct = countProduct;
        this.number = number;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person " + age + " лет. " + "Customer number №" + number + " with " + countProduct + " product";
    }

}
