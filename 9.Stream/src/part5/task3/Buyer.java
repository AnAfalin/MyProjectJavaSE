package part5.task3;

import java.util.Map;

public class Buyer {
    private String name;
    private Map<Product, Integer> shoppingList;

    public Buyer(String name, Map<Product, Integer> shoppingList) {
        this.name = name;
        this.shoppingList = shoppingList;
    }

    public String getName() {
        return name;
    }

    public Map<Product, Integer> getShoppingList() {
        return shoppingList;
    }

    @Override
    public String toString() {
        return  name + " shopping list: "+ shoppingList;
    }
}

