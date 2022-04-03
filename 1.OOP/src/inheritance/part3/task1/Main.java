package inheritance.part3.task1;

import oop.inheritance.part3.task1.p1.Person;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.print();
        oop.inheritance.part3.task1.p2.Person p2 = new oop.inheritance.part3.task1.p2.Person();
        p2.print();
    }
}
