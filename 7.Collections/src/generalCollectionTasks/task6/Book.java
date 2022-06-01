package generalCollectionTasks.task6;

class Book {
    private String title;
    private String author;
    private int countBorrow;

    public Book(String author, String title) {

        this.author = author;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getCountBorrow() {
        return countBorrow;
    }

    public void addCountBorrow() {
        countBorrow++;
    }

    @Override
    public String toString() {
        return "\"" + title + "\" " + author;
    }
}