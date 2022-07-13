package part5.task4;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Solution {
    public static String[] title = {"About Me", "Sea", "Sun", "Summer", "It is love", "Me and my friends", "Happy New Year",
            "My new life", "About IT and Java", "Java or C++"};
    public static List<Post> postList = new ArrayList<>();

    public static void main(String[] args) {
        fillPostList();
        printPostList();

        System.out.println("Последние пять постов (Пять самых \"Свежих\" постов): ");
        postsBefore(5).forEach(System.out::println);

    }

    public static void fillPostList(){
        for (int i = 0; i < 10; i++) {
            int id = i * 2 + i + 1;
            int rating = new Random().nextInt(0, 100);
            int hour = new Random().nextInt(0, 24);
            int minute = new Random().nextInt(0, 60);
            int second = new Random().nextInt(0, 60);
            LocalTime localTime = LocalTime.of(hour, minute, second);
            if (localTime.isAfter(LocalTime.now())) {
                LocalDate yesterday = LocalDate.now().minusDays(1);
                postList.add(new Post(id, title[i], rating,
                        LocalDateTime.of(yesterday, localTime)));
            } else postList.add(new Post(id, title[i], rating,
                    LocalDateTime.of(LocalDate.now(), localTime)));
        }
    }

    public static void printPostList(){
        System.out.println("All available posts:");
        postList.forEach(System.out::println);
        System.out.println();
    }

    public static List<String> postsBefore(int count){
        List<String> postsBefore = postList
                .stream()
                .sorted((o1, o2) -> o2.getPostTime().compareTo(o1.getPostTime()))
                .map(Post::getTitle)
                .limit(count)
                .toList();

        return postsBefore;
    }
}
