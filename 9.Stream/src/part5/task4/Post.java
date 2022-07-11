package part5.task4;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Post {
    private int id;
    private String title;
    private int rating;
    private LocalTime postTime;

    public Post(int id, String title, int rating, LocalTime postTime) {
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

    public LocalTime getPostTime() {
        return postTime;
    }



    @Override
    public String toString() {
        return "Post: id:" + id + ", title:" + title + ", rating:" + rating + ", timePost: " + postTime.format(DateTimeFormatter.ofPattern("hh:mm:ss"));
    }
}
