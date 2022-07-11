package part5.task3;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Product[] products = {
                new Product("Молоко", 40),
                new Product("Йогурт", 20),
                new Product("Кефир", 30),
                new Product("Сыр", 100),
                new Product("Творог", 60),
                new Product("Хлеб", 40),
                new Product("Яйца", 150)
        };

        String[] buyersName = {"Alex", "Sam", "Liza", "Jane", "Peter"};

        List<Buyer> buyerList = new ArrayList<>();

        for (int i = 0; i < buyersName.length; i++) {
            Map<Product, Integer> productsCountMap = new HashMap<>();
            for (int j = 0; j < 3; j++) {
                int id = new Random().nextInt(0, products.length);
                int count = new Random().nextInt(1, 5);
                productsCountMap.put(products[id], count);

            }
            buyerList.add(new Buyer(buyersName[i], productsCountMap));

        }

        for (Buyer buyer : buyerList) {
            System.out.println(buyer);
        }

        int sum = buyerList
                .stream()
                .map(Buyer::getShoppingList)
                .map(Map::entrySet)
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.summingInt(Map.Entry::getValue)))
                .entrySet()
                .stream()
                .map(entry -> entry.getValue() * entry.getKey().getPrice())
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Всего покупатели постратили: " + sum);


        Product popularProduct = buyerList
                .stream()
                .map(buyer -> buyer.getShoppingList())
                .flatMap(map -> map.entrySet().stream())
                .collect(Collectors.groupingBy(entry -> entry.getKey(),
                        Collectors.summingInt(entry -> entry.getValue())))
                .entrySet()
                .stream()
                .max()
                .get()
                .getKey();

        System.out.println("Продукт, который чаще всего покупают " + popularProduct.getTitle());


    }


}
