package abstraction.part1.task3;

public abstract class Director {
    private String name;
    private int age;
    private int experience;

    public Director(String name, int age, int experience) {
        this.name = name;
        this.age = age;
        this.experience = experience;
    }

    public abstract void makeReport(String title);

}
