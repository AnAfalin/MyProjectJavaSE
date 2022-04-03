package basics.part3.task1;

public class Main {
    public static void main(String[] args) {
        Firm firm1 = new Firm("Химтэк", 45, 450_000.00);
        Firm firm2 = new Firm("Рост", 10, 50_000.00);
        Firm firm3 = new Firm("WPI", 75, 1_250_000.00);
        Firm firm4 = new Firm("Sun", 15, 100_000.00);

        Firm[] arrayOfFirm = new Firm[4];
        arrayOfFirm[0] = firm1;
        arrayOfFirm[1] = firm2;
        arrayOfFirm[2] = firm3;
        arrayOfFirm[3] = firm4;

        int totalQuantity = 0;
        double totalProfit = 0;
        for (int i = 0; i < arrayOfFirm.length; i++) {
            totalProfit += arrayOfFirm[i].getProfit();
            totalQuantity += arrayOfFirm[i].getQuantity();
        }
        System.out.println("Общая прибыль всех созданных фирм составляет: " + totalProfit);
        System.out.println("Общее количество работников в фирме составляет : " + totalQuantity);
        System.out.println("Среднее количество количество работников в фирме составляет : " + totalQuantity / arrayOfFirm.length);
    }


}
