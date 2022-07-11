package part5.task2;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Map<Product, Integer> map = new HashMap<>();
        String[] products = {"Яйца(1д)", "Сахар(1кг)", "Масло(1п = 200гр))", "Сыр(1кг)", "Молоко(1л)", "Кефир(1л)", "Овощи(1кг)", "Фрукты(1кг)"};

        for (int i = 0; i < products.length; i++) {
            int count = new Random().nextInt(1, 5);
            map.put(new Product(products[i], new Random().nextInt(50, 150)), count);
            ;
        }
        for (Map.Entry<Product, Integer> productIntegerEntry : map.entrySet()) {
            System.out.println(productIntegerEntry);
        }

        Product popularProduct = map
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .get()
                .getKey();

        System.out.println("\nСамый популярный товар: " + popularProduct);

        Map<Product, Integer> mapExpenses = map
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        product -> product.getKey(),
                        product -> product.getKey().getPrice() * product.getValue())
                );

        System.out.println("\nТовар - Кол-во д/с, потраченных на товар");
        for (Map.Entry<Product, Integer> productIntegerEntry : mapExpenses.entrySet()) {
            System.out.println(productIntegerEntry.getKey() + " - " + productIntegerEntry.getValue());
        }

    }
}
