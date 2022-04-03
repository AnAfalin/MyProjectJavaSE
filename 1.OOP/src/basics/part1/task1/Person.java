package basics.part1.task1;

public class Person {
    private String name;
    private String surname;
    private int age;

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public void printInfo() {
        System.out.println("Имя: " + name + "\nФамилия: " + surname + "\nВозраст: " + age);
    }

    public void goShop() {
        System.out.println(name + " сходил в магазин");
    }

    public void doWork(String work) {
        System.out.println(name + "сделал работу: " + work);
    }
}

