package mapCollection.part2.task2;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Map<Integer, String> patients = new HashMap<>();

        patients.put(1, "Илья");
        patients.put(2, "Иван");
        patients.put(3, "Дарья");
        patients.put(4, "Ирина");
        patients.put(5, "Дмитрий");
        patients.put(6, "Сергей");
        patients.put(7, "Вера");
        patients.put(8, "Евгений");
        patients.put(9, "Михаил");
        patients.put(10, "Евгения");


        System.out.println(patients);

        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите id (1-10) пациента для получения информаци о нем");
            if (scanner.hasNextInt()) {
                int id = scanner.nextInt();
                if(id > 0 && id <= 10) {
                    System.out.println("Пациент с номером id " + id + " это: " + patients.get(id));
                    break;
                }else {
                    System.out.println("Пациент с номером id " + id + " не найден. Повторите ввод.");
                }
            }
        }while (true);

        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите id (1-10) пациента для замены пациента");
            if (scanner.hasNextInt()) {
                int id = scanner.nextInt();
                if(id > 0 && id <= 10) {
                    System.out.println("Введите имя нового пациента");
                    String name = scanner.next();
                    patients.put(id, name);
                    break;
                }else {
                    System.out.println("Пациент с номером id " + id + " не найден. Повторите ввод.");
                }
            }

        }while (true);

        System.out.println(patients);

        for (int i = patients.size(); i >= 0 ; i--) {
            if(i % 2 == 0){
                patients.remove(i);
            }
        }

        System.out.println(patients);
    }
}
