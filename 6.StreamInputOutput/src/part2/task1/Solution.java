package part2.task1;

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Person person1 = new Person("Mike", 45);
        Person person2 = new Person("Sara", 20);
        Person person3 = new Person("Tom", 30);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("6.StreamInputOutput/src/part2/task1/Person.bin"));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream("6.StreamInputOutput/src/part2/task1/Person.bin"))){
            oos.writeObject(person1);
            oos.writeObject(person2);
            oos.writeObject(person3);

            Person savePerson = (Person) ois.readObject();
            Person savePerson1 = (Person) ois.readObject();
            Person savePerson2 = (Person) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
