package part3.task1;

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Person[] array = new Person[3];
        array[0] = new Person("Christian", "Grey", 30, Job.PROGRAMMER, new Animal[]{Animal.CAT, Animal.DOG});
        array[1] = new Person("Mike", "Scott", 20, Job.MANAGER, new Animal[]{Animal.CAT});
        array[2] = new Person("Ana", "Wilson", 22, Job.ANALYST, new Animal[]{Animal.CAT, Animal.FISH, Animal.DOG});

        System.out.println("Array for save in files:");
        for (Person el:array) {
            System.out.println(el);
        }

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("6.StreamInputOutput/src/part3/task1/DataArray.txt"))){
            int n = 1;
            for (Person el:array) {
                bufferedWriter.write(n + ". ");
                bufferedWriter.write(el.toString());
                bufferedWriter.write("\n");
                n++;
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        System.out.println("\nReading a file with saved data...");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("6.StreamInputOutput/src/part3/task1/DataArray.txt"))){
            String readString;
            while ((readString = bufferedReader.readLine()) != null){
                System.out.println(readString);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
