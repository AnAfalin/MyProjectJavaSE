package generalCollectionTasks.task5;

public class Customer {
    private final int age;
    public int countProduct;    //количество продуктов
    public int number;

    public Customer(int age, int countProduct, int number) {
        this.age = age;
        this.countProduct = countProduct;
        this.number = number;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Покупатель №" + number + " " + age + " лет. " + " товаров - " + countProduct;
    }

}
