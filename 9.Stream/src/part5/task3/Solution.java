package part5.task3;


import java.util.*;


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
            int id = new Random().nextInt(0, products.length);
            int count = new Random().nextInt(1, 5);
            productsCountMap.put(products[id], count);
            buyerList.add(new Buyer(buyersName[i], productsCountMap));
        }

        for (Buyer buyer : buyerList) {
            System.out.println(buyer);
        }


    }


}
