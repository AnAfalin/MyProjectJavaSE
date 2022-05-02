package part1.task7;

public class Students {
    private String name;
    private String lastName;
    private int group;
    private double mark;

    public Students(String name, String lastName, int group, double mark) {
        this.name = name;
        this.lastName = lastName;
        this.group = group;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", group=" + group +
                ", mark=" + mark +
                '}';
    }
}
