package part1.task2;

class Account<T> {
    private T balance;

    public void setBalance(T balance) {
        this.balance = balance;
    }

//    public double getBalance() {
//        return Double.parseDouble(balance.toString());
//    }

    public double getBalance() {
        if(balance instanceof Integer){
            return (Integer)balance;
        }
        else if (balance instanceof Double){
            return (Double)balance;
        }
        else {
            String balanceStr = ((String) balance).substring(0, ((String) balance).indexOf(" "));
            return Double.parseDouble(balanceStr);
        }
    }


}

class Main{
    public static void main(String[] args) {
        Account<Integer> acc = new Account<>();
        acc.setBalance(500);
        System.out.println(acc.getBalance());

        Account<String> acc1 = new Account<>();
        acc1.setBalance("4000 Rub");
        System.out.println(acc1.getBalance());

        Account<Double> acc2 = new Account<>();
        acc2.setBalance(500.55);
        System.out.println(acc2.getBalance());

    }
}
