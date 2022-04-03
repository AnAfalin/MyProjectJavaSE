package abstraction.part1.task3;

public class Main {
    public static void main(String[] args) {
        HRDirector employee1 = new HRDirector("Mike", 40, 15);
        employee1.hireEmployee("Jane");
        employee1.makeReport(" \"Отчет о новом сотруднике\" ");

        FinanceDirector employee2 = new FinanceDirector("Stive", 20, 2);
        employee2.makeReport("\"Финансовый план на год\"");
    }
}
