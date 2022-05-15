package mapCollection.part2.task3;

public class Employee {
    private String name;
    private int experienceWork;

    public Employee(String name, int experienceWork) {
        this.name = name;
        this.experienceWork = experienceWork;
    }

    @Override
    public String toString() {
        return "Имя: " + name + " стаж работы: " + experienceWork;
    }
}
