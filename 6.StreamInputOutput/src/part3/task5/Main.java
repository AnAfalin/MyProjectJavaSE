package part3.task5;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Person[] people = new Person[3];
        people[0] = new Person("Christian", "Grey", 30, "Programmer", new String[]{"Cat", "Dog"});
        people[1] = new Person("Mike", "Scott", 20, "Manager", new String[]{"Cat"});
        people[2] = new Person("Ana", "Wilson", 22, "Programmer", new String[]{"Cat", "Dog", "Fish"});

        List<Map<String, String>> list = new ArrayList<>();

        Solution solution = new Solution();
        solution.fillMap(people, list);

        solution.saveJSONFile(list, "6.StreamInputOutput/src/part3/task5/JSON_data.json");
        solution.downloadJSONFile("6.StreamInputOutput/src/part3/task5/JSON_data.json");

    }
}
