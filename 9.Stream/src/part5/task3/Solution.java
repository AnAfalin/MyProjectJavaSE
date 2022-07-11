package part5.task3;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public static Product[] products = {
            new Product("Молоко", 40),
            new Product("Йогурт", 20),
            new Product("Кефир", 30),
            new Product("Сыр", 100),
            new Product("Творог", 60),
            new Product("Хлеб", 40),
            new Product("Конфеты", 50),
            new Product("Мясо", 1000),
            new Product("Сметана", 20),
            new Product("Яйца", 150)
    };
    public static String[] buyersName = {"Alex", "Sam", "Liza", "Jane", "Peter"};
    public static List<Buyer> buyerList = new ArrayList<>();

    public static void main(String[] args) {
        fillBuyerList();
        System.out.println("Покупатели и их чеки");
        printBuyerList();

        System.out.println("Всего покупатели потратили: " + revenue());
        System.out.println("Продукт, который чаще всего покупают " + popularGood().getTitle() + "\n");
        System.out.println("Средняя стоимость чека равна " + averageCostReceipt());
        System.out.println("Топ-5 самых неликвидных товаров: " + fiveIlliquidGoods());


    }

    public static void fillBuyerList(){
        for (int i = 0; i < buyersName.length; i++) {
            Map<Product, Integer> productsCountMap = new HashMap<>();
            for (int j = 0; j < 3; j++) {
                int id = new Random().nextInt(0, products.length);
                int count = new Random().nextInt(1, 5);
                productsCountMap.put(products[id], count);
            }
            buyerList.add(new Buyer(buyersName[i], productsCountMap));
        }
    }

    public static void printBuyerList(){
        for (Buyer buyer : buyerList) {
            System.out.println(buyer);
        }
        System.out.println();
    }

    public static int revenue() {
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

        return sum;
    }

    public static Product popularGood(){
        Product popularProduct = buyerList
                .stream()
                .map(Buyer::getShoppingList)
                .flatMap(map -> map.entrySet().stream())
                .collect(Collectors.groupingBy(Map.Entry::getKey,
                        Collectors.summingInt(Map.Entry::getValue)))
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .get()
                .getKey();

        return popularProduct;
    }

    public static double averageCostReceipt(){
        double averageCostReceipt = buyerList
                .stream()
                .collect(Collectors.toMap(Buyer::getShoppingList, el -> el.getShoppingList().size()))
                .entrySet()
                .stream()
                .map(entry ->
                        (entry
                                .getKey()
                                .entrySet()
                                .stream()
                                .map(l -> l.getKey().getPrice() * l.getValue())
                                .mapToDouble(Integer::doubleValue)
                                .sum()) / entry.getValue())
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);

        return averageCostReceipt;
    }

    public static List<String> fiveIlliquidGoods(){
        List<String> illiquidGoods = Stream.concat(
                        buyerList
                                .stream()
                                .flatMap(el -> el.getShoppingList().entrySet().stream())
                                .collect(Collectors.groupingBy(
                                        element -> element.getKey().getTitle(),
                                        Collectors.summingInt(element -> element.getValue())))
                                .entrySet()
                                .stream(),

                        Arrays.stream(products)
                                //.map(Product::getTitle)
                                .collect(Collectors.groupingBy(Product::getTitle, Collectors.summingInt(m -> 0)))
                                .entrySet()
                                .stream()
                )
                .collect(Collectors.groupingBy(
                        stream -> stream.getKey(),
                        Collectors.summingInt(stream -> stream.getValue())))
                .entrySet()
                .stream()
                .sorted((o1, o2) -> Integer.compare(o1.getValue(), o2.getValue()))
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();

        return illiquidGoods;
    }
}