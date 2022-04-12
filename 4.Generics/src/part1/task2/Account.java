package part1.task2;

class Account<T> {
    private T balance;

    public void setBalance(T balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return Double.parseDouble(balance.toString());
    }

}

class Main{
    public static void main(String[] args) {
        Account<Integer> acc = new Account<>();
        acc.setBalance(500);
        System.out.println(acc.getBalance());


    }
}
