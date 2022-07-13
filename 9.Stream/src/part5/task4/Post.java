package part5.task4;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Post {
    private int id;
    private String title;
    private int rating;
    private LocalDateTime postTime;

    public Post(int id, String title, int rating, LocalDateTime postTime) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.postTime = postTime;
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

    public LocalDateTime getPostTime() {
        return postTime;
    }

    @Override
    public String toString() {
        return postTime.format(DateTimeFormatter.ofPattern("yyyy:MM:dd HH:mm:ss"))  + " Post: id:" + id + ", title:" + title + ", rating:" + rating;
    }
}
