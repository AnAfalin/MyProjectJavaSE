package part2.task2;

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Person person1 = new Person("Mike", 45);
        Person person2 = new Person("Sara", 20);
        Person person3 = new Person("Tom", 30);
        
        Person[] arrPerson = new Person[3];
        arrPerson[0] = person1;
        arrPerson[1] = person2;
        arrPerson[2] = person3;

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("6.StreamInputOutput/src/part2/task2/PersonArray.bin"));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream("6.StreamInputOutput/src/part2/task2/PersonArray.bin"))){

            oos.writeObject(arrPerson);
            Person[] array = (Person[])ois.readObject();
            for (Person el:array) {
                System.out.println(el);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
