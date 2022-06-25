package part2.task3;

import part2.task2.Person;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Person[] people = {
                new Person(40),
                new Person(18),
                new Person(16),
                new Person(30),
                new Person(14)
        };

        boolean isOneAdult = false;
        for (Person person:people) {
            if (person.getAge() >= 18) {
                isOneAdult = true;
                break;
            }

        }
        System.out.println("Хотя бы один из людей является совершеннолетним ? - " + isOneAdult);

        System.out.println("Хотя бы один из людей является совершеннолетним ? - " +
                Arrays.stream(people)
                .anyMatch(person -> person.getAge() >= 18));
    }
}
