package hashSetCollection.part1.task6;

import java.util.HashSet;
import java.util.Objects;


public class Solution {
    public static void main(String[] args) {
        HashSet<Person> personHashSet = new HashSet<>();
        Person p1 = new Person("Tom", 25);
        Person p2 = new Person("Bob", 70);

        personHashSet.add(p1);
        personHashSet.add(p1);
        personHashSet.add(p2);

        System.out.println(personHashSet); //[Bob 70, Tom 25]

        System.out.println(p1.hashCode()); //2613480

        p1.setName("Alex");

        System.out.println(p1.hashCode()); //63348060

        System.out.println(personHashSet); //[Bob 70, Alex 25]

        System.out.println(personHashSet.contains(p1)); //false
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //без переопределения методов equals и hashCode - хешкод объектов вычисляется по ссылке
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return name + " " + age;
    }


}

