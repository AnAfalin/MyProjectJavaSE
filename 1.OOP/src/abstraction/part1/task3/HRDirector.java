package abstraction.part1.task3;

public class HRDirector extends Director{


    public HRDirector(String name, int age, int experience) {
        super(name, age, experience);
    }

    @Override
    public void makeReport(String title) {
        System.out.println("Report " + title + " is ready!");
    }

    public void hireEmployee(String nameEmployee) {
        System.out.println("A new employee " + nameEmployee + " has been hired.");
    }

}
