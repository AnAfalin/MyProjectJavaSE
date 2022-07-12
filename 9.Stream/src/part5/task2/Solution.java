package part5.task2;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Map<Product, Integer> mapCashReceipt = new HashMap<>();
        String[] products = {"Яйца(1д)", "Сахар(1кг)", "Масло(1п = 200гр))", "Сыр(1кг)", "Молоко(1л)", "Кефир(1л)", "Овощи(1кг)", "Фрукты(1кг)"};

        Random random = new Random();

        for (int i = 0; i < products.length; i++) {
            int count = random.nextInt(1, 5);
            mapCashReceipt.put(new Product(products[i], random.nextInt(50, 150)), count);
        }
        mapCashReceipt.entrySet().forEach(System.out::println);

        Optional<Map.Entry<Product, Integer>> popularProduct = mapCashReceipt
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());

        System.out.println("\nСамый популярный товар: " + popularProduct);

        Map<Product, Integer> mapExpenses = mapCashReceipt
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        product -> product.getKey(),
                        product -> product.getKey().getPrice() * product.getValue())
                );

        System.out.println("\nТовар - Кол-во д/с, потраченных на товар");
        mapExpenses.entrySet().forEach(System.out::println);

    }
}
