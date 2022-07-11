package part5.task4;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        List<Post> postList = new ArrayList<>();
        String[] title = {"About Me", "Sea", "Sun", "Summer", "It is love", "Me and my friends", "Happy New Year",
        "My new life", "About IT and Java", "Java or C++"};
        for (int i = 0; i < 10; i++) {
            int id = i * 2 + i + 1;
            int rating = new Random().nextInt(0, 100);
            int hour = new Random().nextInt(0, 24);
            int minute = new Random().nextInt(0, 60);
            int second = new Random().nextInt(0, 60);
            LocalTime localTime = LocalTime.of(hour, minute, second);
            postList.add(new Post(id, title[i], rating, localTime));
        }
        postList.sort((o1, o2) -> o1.getPostTime().compareTo(o2.getPostTime()));

        System.out.println("All available posts:");
        for (int i = 0; i < postList.size(); i++) {
            System.out.println(postList.get(i));
        }
        System.out.println();

        System.out.println("Последние пять постов (Пять самых \"Свежих\" постов):");

        List<String> postsBefore = postList
                .stream()
                .sorted((o1, o2) -> o1.getPostTime().compareTo(o2.getPostTime()))
                .filter(post -> post.getPostTime().isBefore(LocalTime.of(01, 00)))
                .map(Post::getTitle)
                .limit(5)
                .toList();

        if(postsBefore.size() < 6){
            System.out.println(postsBefore);
            postList
                    .stream()
                    .filter(post -> post.getPostTime().isAfter(LocalTime.of(01, 00)))
                    .sorted((o1, o2) -> o2.getPostTime().compareTo(o1.getPostTime()))
                    .limit(5 - postsBefore.size())
                    .forEach(post -> System.out.println(post.getTitle()));
        }
    }
}
