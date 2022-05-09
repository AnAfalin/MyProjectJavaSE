package part4.task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<PersonV1> list1 = new ArrayList<>();
        list1.add(new PersonV1("Bob", 45));
        list1.add(new PersonV1("Peter", 80));
        list1.add(new PersonV1("Mike", 40));
        list1.add(new PersonV1("Liza", 20));
        list1.add(new PersonV1("Tom", 30));

        System.out.println("Список №1");
        System.out.println(list1);
        Collections.sort(list1);
        System.out.println("Список №1 после сортировки по возрастанию возраста с помощью метода класса Comparable, переопределенного внутри класса");
        System.out.println(list1);

        List<PersonV2> list2 = new ArrayList<>();
        list2.add(new PersonV2("Bob", 45));
        list2.add(new PersonV2("Peter", 80));
        list2.add(new PersonV2("Mike", 40));
        list2.add(new PersonV2("Liza", 20));
        list2.add(new PersonV2("Tom", 30));
        System.out.println("Список №2");
        System.out.println(list2);
        System.out.println("Список №2 после сортироки методом класса");
        Collections.sort(list2);
        System.out.println("Список №2 после сортировки по убыванию возраста с помощью метода класса Comparable, переопределенного внутри класса");
        System.out.println(list2);


        Comparator<PersonV1> comparator = new Comparator<>() {
            @Override
            public int compare(PersonV1 o1, PersonV1 o2) {
                return Integer.compare(o1.getName().compareTo(o2.getName()), 0);
            }
        };


        Collections.sort(list1, comparator);
        System.out.println("Список №1 после сортироки по возрастанию имени методом класса Comparator");
        System.out.println(list1);

        Comparator<PersonV2> comparator1 = new Comparator<>() {
            @Override
            public int compare(PersonV2 o1, PersonV2 o2) {
                return Integer.compare(o2.getName().compareTo(o1.getName()), 0);
            }
        };

        Collections.sort(list2, comparator1);
        System.out.println("Список №2 после сортироки по убыванию имени методом класса Comparator");
        System.out.println(list2);
    }
}
