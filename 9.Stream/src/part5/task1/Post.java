package part5.task1;

public class Post {
    private int id;
    private String title;
    private int rating;

    public Post(int id, String title, int rating) {
        this.id = id;
        this.title = title;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Post: id:" + id + ", title:" + title + ", rating:" + rating;
    }
}
