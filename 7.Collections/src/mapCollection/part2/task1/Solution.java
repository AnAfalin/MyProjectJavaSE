package mapCollection.part2.task1;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Map<String, String> dataOfPassport = new HashMap<>();
        dataOfPassport.put("4020788455", "Иванов Иван Иваноыич");
        dataOfPassport.put("4050741589", "Петрова Ольга Семеновна");
        dataOfPassport.put("4015455623", "Сергеев Илья Дмитрович");


        System.out.println("\nВывод ключей");
        Set<String> setKeys = dataOfPassport.keySet();
        for (String el:setKeys) {
            System.out.println(el);
        }


        System.out.println("\nВывод значений");
        Collection<String> collectionValues = dataOfPassport.values();
        for (String el:collectionValues) {
            System.out.println(el);
        }


        System.out.println("\nВывод всех пар ключ-значение");
        Set<Map.Entry<String, String>> setPairs = dataOfPassport.entrySet();
        for (Map.Entry<String, String> el:setPairs) {
            System.out.println(el);
        }

        List<Map.Entry<String, String>> listPairs = new ArrayList<>(setPairs);


        System.out.println("\nВывод значений списка");
        for (Map.Entry<String, String> listPair : listPairs) {
            System.out.println(listPair);
        }

    }
}
