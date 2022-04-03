package inheritance.part2.task1;

public class Programmer extends Employee{
    private String programmingLanguage;

    public Programmer(String name, int experience, String programmingLanguage) {
        super(name, experience);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public String printClass() {
        return "Это унаследованный класс Programmer";
    }
}
