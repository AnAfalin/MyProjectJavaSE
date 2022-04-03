package inheritance.part2.task1;

public class Employee {
    private String name;
    private int experience; //стаж

    public Employee(String name, int experience) {
        this.name = name;
        this.experience = experience;
    }

    public String printClass() {
        return "Это класс Employee";
    }
}
