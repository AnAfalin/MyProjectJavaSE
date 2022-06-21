package part1.task7;

import java.util.List;
import java.util.Map;

public class Student {
    private String name;
    private Map<String, List<Integer>> marks; //название предмета - список оченок по нему

    public Student(String name, Map<String, List<Integer>> marks) {
        this.name = name;
        this.marks = marks;
    }

    public Map<String, List<Integer>> getMarks() {
        return marks;
    }

    public String getName() {
        return name;
    }
}
