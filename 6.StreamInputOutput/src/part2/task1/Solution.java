package part2.task1;

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Person person1 = new Person("Mike", 45);
        Person person2 = new Person("Sara", 20);
        Person person3 = new Person("Tom", 30);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("6.StreamInputOutput/src/part2/task1/Person.bin"))){
            oos.writeObject(person1);
            oos.writeObject(person2);
            oos.writeObject(person3);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("6.StreamInputOutput/src/part2/task1/Person.bin"))){

            Person savePerson = (Person) ois.readObject();
            System.out.println(savePerson);
            Person savePerson2 = (Person) ois.readObject();
            System.out.println(savePerson2);
            Person savePerson3 = (Person) ois.readObject();
            System.out.println(savePerson3);


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
