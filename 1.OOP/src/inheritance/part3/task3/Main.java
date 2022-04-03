package inheritance.part3.task3;

public class Main {
    public static void main(String[] args) {
        Director director = new Director("Mike",10, "HR-Director" );
        System.out.println(director);

        Programmer programmer = new Programmer("Max", 5, "Java");
        System.out.println(programmer);
    }
}
