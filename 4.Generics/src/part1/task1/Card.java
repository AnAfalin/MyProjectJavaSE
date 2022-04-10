package part1.task1;

class Card<K, V> {
    private K password;
    private V number;

    public Card(K password, V number) {
        this.password = password;
        this.number = number;
    }

    public K getPassword() {
        return password;
    }

    public void setPassword(K password) {
        this.password = password;
    }

    public V getNumber() {
        return number;
    }

    public void setNumber(V number) {
        this.number = number;
    }

    public void printInfo () {
        System.out.println("password: " + password);
        System.out.println("number of card: " + number);
    }

}

