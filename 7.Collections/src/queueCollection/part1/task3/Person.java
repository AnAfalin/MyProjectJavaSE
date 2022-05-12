package queueCollection.part1.task3;

public class Person implements Comparable {
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

    @Override
    public int compareTo(Object o) {
        return this.getName().compareTo(((Person)o).getName());
    }
}
