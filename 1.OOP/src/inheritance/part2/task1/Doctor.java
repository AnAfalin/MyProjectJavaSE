package inheritance.part2.task1;

public class Doctor extends Employee {
    private String specialization;

    public Doctor(String name, int experience, String specialization) {
        super(name, experience);
        this.specialization = specialization;
    }

    @Override
    public String printClass() {
        return "Это унаследованный класс Doctor";
    }
}
