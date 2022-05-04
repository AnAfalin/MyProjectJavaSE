package part2.task4;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {

    @Serial
    private static final long serialVersionUID = -7289795986573791762L;

    private String firstName;
    private String lastName;
    transient ArrayList<Double> listOfMark;

    public Student(String firstName, String lastName, ArrayList<Double> listOfMark) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.listOfMark = listOfMark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", listOfMark=" + listOfMark +
                '}';
    }
}
