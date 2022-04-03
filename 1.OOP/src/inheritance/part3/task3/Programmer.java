package inheritance.part3.task3;

public class Programmer extends Employee{
    private String languageProgramming;

    public Programmer(String name, int workExperience, String languageProgrammer) {
        this.name = name;
        this.workExperience = workExperience;
        this.languageProgramming = languageProgrammer;
    }

    @Override
    public String toString() {
        return "Programmer" +
                " имя: " + name +
                "\nстаж работы: " + workExperience +
                "\nязык программирования: " + languageProgramming;
    }
}
