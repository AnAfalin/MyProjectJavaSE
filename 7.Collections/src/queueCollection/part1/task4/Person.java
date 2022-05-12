package queueCollection.part1.task4;

public class Person {
    private String name;
    private String surname;

    public Person(String firstName, String lastName) {
        this.name = firstName;
        this.surname = lastName;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }

}
