package abstraction.part1.task3;

public class FinanceDirector extends Director {

    public FinanceDirector(String name, int age, int experience) {
        super(name, age, experience);
    }

    @Override
    public void makeReport(String title) {
        System.out.println("Finance plan " + title + " is ready!");
    }
}
