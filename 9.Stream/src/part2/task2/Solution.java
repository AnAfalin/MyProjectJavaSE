package part2.task2;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Person[] people = {
                new Person(40),
                new Person(18),
                new Person(16),
                new Person(30),
                new Person(50)
        };

        boolean isAllAdult = true;
        for (Person person : people) {
            if (person.getAge() < 18) {
                isAllAdult = false;
                break;
            }
        }
        if(isAllAdult){
            System.out.println("Все люди совершеннолетние");
        }else {
            System.out.println("Не все люди совершеннолетние");
        }


        System.out.println("Все люди совершеннолетние? - " +
                Arrays.stream(people)
                .allMatch(x->x.getAge() >= 18));
    }
}
