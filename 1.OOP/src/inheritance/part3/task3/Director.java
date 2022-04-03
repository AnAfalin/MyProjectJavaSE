package inheritance.part3.task3;

public class Director extends Employee{
    private String position;


    public Director(String name, int workExperience, String position) {
        this.name = name;
        this.workExperience = workExperience;
        this.position = position;
    }

    @Override
    public String toString() {
        return "Director" +
                " имя: " + name +
                "\nдолжность: " + position +
                "\nстаж работы: " + workExperience;
    }
}
