package part5.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        List<Post> postList = new ArrayList<>();
        String[] title = {"About Me", "Sea", "Sun", "Summer", "It is love", "Me and my friends", "Happy New Year",
        "My new life", "About IT and Java", "Java or C++"};
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int id = i * 2 + i + 1;
            int rating = random.nextInt(0, 100);
            postList.add(new Post(id, title[i], rating));
        }

        System.out.println("All available posts:");
        postList.forEach(System.out::println);

        List<Post> fivePostMaxRating = postList
                .stream()
                .sorted((o1, o2) -> Integer.compare(o2.getRating(), o1.getRating()))
                .limit(5)
                .toList();

        System.out.println("\nThe five best posts: ");
        fivePostMaxRating.forEach(System.out::println);

    }
}
