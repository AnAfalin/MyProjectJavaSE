package basics.part3.task1;

public class Firm {
    private String title; //название фирмы
    private int quantity; //количество работников
    private double profit; //прибыль фирмы

    public Firm(String title, int quantity, double profit) {
        this.title = title;
        this.quantity = quantity;
        this.profit = profit;
    }

    public String getTitle() {
        return title;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getProfit() {
        return profit;
    }
}


