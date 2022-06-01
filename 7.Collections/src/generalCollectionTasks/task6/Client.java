package generalCollectionTasks.task6;

public class Client {
    private int number;
    private Book bookBorrow;
    public int timeBorrow;

    public Client(int number, Book bookBorrow, int timeBorrow) {
        this.number = number;
        this.bookBorrow = bookBorrow;
        this.timeBorrow = timeBorrow;
    }

    public Book getBookBorrow() {
        bookBorrow.addCountBorrow();
        return bookBorrow;
    }

    public int getNumber() {
        return number;
    }
}
