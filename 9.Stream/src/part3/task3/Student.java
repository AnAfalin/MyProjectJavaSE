package part3.task3;

import java.util.Map;

class Student {
    private String name;
    private Map<String, Integer> marks;

    public Student(String name, Map<String, Integer> marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public Map<String, Integer> getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return name + " " + marks;
    }
}
