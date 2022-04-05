package enumeration.task2;

public class Human {
    private String name;
    private int age;
    private Gender gender;

    public Human(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Человек с ФИО: " + name + ".\nВозраст: " + age + ".\nПол: " + gender;
    }
}
