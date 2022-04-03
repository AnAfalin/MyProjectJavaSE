package polymorphism.part2.task5;

public class Person {
    String name;

    public Person(String name) {
        System.out.println("Вызов конструктора Person");
        this.name = name;
        printInfo();
    }

    private void printInfo(){
        //данный метод помечается как private или final, или static (одно из).
        //чтобы гарантировать, что метод не будет переопределен в дочернем классе.
        System.out.println("printInfo from Person");
        System.out.println(name.toUpperCase());
    }
}
