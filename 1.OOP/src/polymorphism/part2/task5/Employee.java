package polymorphism.part2.task5;

public class Employee extends Person{
    String job;

    public Employee(String name, String job) {

        super(name);
        System.out.println("Вызов конструктора Employee");
        this.job = job;
    }

    public void printInfo() {
        System.out.println("printInfo from Employee");
        System.out.println(name.toUpperCase() + " " + job.toUpperCase()) ;
    }
}
