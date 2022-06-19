package part2.task1;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
        Person[] people = {
                new Person("Илья", 45),
                new Person("Алексей", 25),
                new Person("Сергей", 25),
                new Person("Ирина", 30),
        };

        System.out.println("Массив до сортирвки");
        System.out.println(Arrays.toString(people));

        //сортировка с помощью обыной реализации компаратора
        Comparator<Person> comparator = new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                if(p1.getAge() == p2.getAge()){
                    return p1.getName().compareTo(p2.getName());
                }
                return Integer.compare(p1.getAge(), p2.getAge());
            }
        };

        Arrays.sort(people, comparator);
        System.out.println(Arrays.toString(people));


        //сортировка с помощью лямбды-выражения компаратора
        Comparator<Person> comp = Comparator.comparingInt(Person::getAge).thenComparing(Person::getName);

        Arrays.sort(people, comp);
        System.out.println(Arrays.toString(people));

    }
}
