package mapCollection.part2.task3;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Map<Employee, Department> office = new HashMap<>();
        Department administration = new Department("Администрация");
        Department accounting = new Department("Бухгалтерия");
        Department departmentSales = new Department("Отдел продаж");
        Department departmentPurchasing = new Department("Отдел закупок");

        Employee employee1 = new Employee("Ирина", 5);
        Employee employee2 = new Employee("Анастасия", 3);
        Employee employee3 = new Employee("Дмитрий", 7);
        Employee employee4 = new Employee("Евгений", 2);
        Employee employee5 = new Employee("Светлана", 4);
        Employee employee6 = new Employee("Евгения", 5);
        Employee employee7 = new Employee("Вячеслав", 10);

        office.put(employee1, accounting);
        office.put(employee2, accounting);
        office.put(employee3, departmentPurchasing);
        office.put(employee4, departmentPurchasing);
        office.put(employee5, departmentSales);
        office.put(employee6, departmentSales);
        office.put(employee7, administration);

        Set<Map.Entry<Employee, Department>> entrySet = office.entrySet();
        for (Map.Entry<Employee, Department> el : entrySet) {
            System.out.println(el);
        }
        System.out.println("-- -- --");

        //попытка добавить дубликат
        //результат - добавление не произошло
        office.put(employee1, accounting);

        for (Map.Entry<Employee, Department> el : entrySet) {
            System.out.println(el);
        }
        System.out.println("-- -- --");

        //попытка добавить дубликат
        //результат - добавление произошло, т.к. дабавлялся новый объект работника
        office.put(new Employee("Ирина", 5), accounting);

        for (Map.Entry<Employee, Department> el : entrySet) {
            System.out.println(el);
        }
        System.out.println("-- -- --");

        Collection<Department> departmentCollection = office.values();
        Set<Department> departmentSet = new HashSet<>(departmentCollection);
        System.out.println("Количество отделов в офисе равно: " + departmentSet.size());


        int countAdministration = 0;
        int countAccounting = 0;
        int countDepartmentSales = 0;
        int countDepartmentPurchasing = 0;
        Set<Map.Entry<Employee, Department>> entries = office.entrySet();
        for (Map.Entry<Employee, Department> el : entries) {
            if (el.getValue().toString().equals("Администрация")) {
                countAdministration++;
            } else if (el.getValue().toString().equals("Бухгалтерия")) {
                countAccounting++;
            } else if (el.getValue().toString().equals("Отдел продаж")) {
                countDepartmentSales++;
            } else countDepartmentPurchasing++;
        }
        System.out.println("В отеделе: Администрация работает " + countAdministration + " человек");
        System.out.println("В отеделе: Бухгалтерия работает " + countAccounting + " человек");
        System.out.println("В отеделе: Отдел продаж работает " + countDepartmentSales + " человек");
        System.out.println("В отеделе: Отдел закупок работает " + countDepartmentPurchasing + " человек");
    }
}
