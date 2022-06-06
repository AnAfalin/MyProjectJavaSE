package part3.task2;

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args){
        Person[] array = new Person[3];
        array[0] = new Person("Christian", "Grey", 30, "Programmer", new String[]{"Cat", "Dog"});
        array[1] = new Person("Mike", "Scott", 20, "Manager", new String[]{"Cat"});
        array[2] = new Person("Ana", "Wilson", 22, "Programmer", new String[]{"Cat", "Dog", "Fish"});

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("6.StreamInputOutput/src/part3/task2/DataObject.bin"))) {
            objectOutputStream.writeObject(array);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("6.StreamInputOutput/src/part3/task2/DataObject.bin"))) {
            Person[] people = (Person[]) objectInputStream.readObject();
            System.out.println(Arrays.toString(people));
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
