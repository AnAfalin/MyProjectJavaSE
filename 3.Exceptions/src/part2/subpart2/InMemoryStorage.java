package part2.subpart2;

import java.util.Scanner;

public class InMemoryStorage {
    private Person[] arrayPerson;
    private int emptyCell;

    public InMemoryStorage(int size) {
        arrayPerson = new Person[size];
    }

    public void add(Person person){
        arrayPerson[emptyCell] = person;
        emptyCell++;
    }

    public Person getElement(int index){
        if(index < 0 || index >= arrayPerson.length){
            throw new ArrayIndexOutOfBoundsException("Недопустимый индекс");
        }
        return arrayPerson[index];
    }

    public void foundPerson(String name) {

        for (Person person : arrayPerson) {
            if (person.getName().equalsIgnoreCase(name)) {
                System.out.println("Человек с указанным Вами именем \"" + name + "\" найден.");
                System.out.println(person);
            } else throw new RuntimeException("Человек с именем \"" + name + "\" отсутствует");
        }
    }

    public void changeAgePerson(int index)  {
        Person foundPerson = null;
        Scanner sc = new Scanner(System.in);
        int newAge = sc.nextInt();
        foundPerson = getElement(index);
        if(newAge < 0 || newAge > 95) {
            throw new IllegalArgumentAgeException("Недопустимое значение возраста");
        }
        foundPerson.setAge(newAge);

    }

    public int getIndexAdultPerson() {
        int index = -1;
        for (int i = 0; i < arrayPerson.length; i++) {
            if(arrayPerson[i].getAge() >= 18) {
                index = i;
            }
        }
        if(index < 0) {
            throw new RuntimeException("Человек с возрастом 18лет не найден");
        }
        else return index;

    }

    private static class IllegalArgumentAgeException extends RuntimeException {
        public IllegalArgumentAgeException(String message) {
            super(message);
        }
    }
}
