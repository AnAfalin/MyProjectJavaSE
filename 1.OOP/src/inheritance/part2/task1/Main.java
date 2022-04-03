package inheritance.part2.task1;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("Jen", 10);
        System.out.println(employee.printClass());
        Doctor doctor = new Doctor("Ekaterina", 12, "therapist");
        System.out.println(doctor.printClass());
        Programmer programmer = new Programmer("Slava", 5, "Java");
        System.out.println(programmer.printClass());
    }
}
