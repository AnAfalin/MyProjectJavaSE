package part1.task7;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employeesList = new LinkedList<>();
        Employee employee1 = new Employee("Alex", "Scott", 35, "Programmer", new String[]{"Moscow", "Vladivostok", "New York"});
        Employee employee2 = new Employee("Mike", "Flex", 20, "Manager", new String[]{"Moscow", "Saratov"});
        employeesList.add(employee1);
        employeesList.add(employee2);

        new FileCreate().getJSONFile(employeesList);
    }
}
