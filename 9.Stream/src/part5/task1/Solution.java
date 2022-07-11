package part5.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        List<Post> postList = new ArrayList<>();
        String[] title = {"About Me", "Sea", "Sun", "Summer", "It is love", "Me and my friends", "Happy New Year",
        "My new life", "About IT and Java", "Java or C++"};
        for (int i = 0; i < 10; i++) {
            int id = i * 2 + i + 1;
            int rating = new Random().nextInt(0, 100);
            postList.add(new Post(id, title[i], rating));
        }

        System.out.println("All available posts:");
        for (Post post : postList) {
            System.out.println(post);
        }

        List<Post> fivePostMaxRating = postList
                .stream()
                .sorted((o1, o2) -> Integer.compare(o2.getRating(), o1.getRating()))
                .limit(5)
                .toList();

        System.out.println("\nThe five best posts: ");
        for (Post post : fivePostMaxRating) {
            System.out.println(post.getTitle());
        }
    }
}
