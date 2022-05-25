package generalCollectionTasks.task2;

import java.util.*;

public class Solution {
    public static void main(String[] args) {

        Set<Integer> set = new HashSet<>();
        Random random = new Random();

        for (int i = 0; i < 30; i++) {
            set.add(random.nextInt(100));
        }

        System.out.println("Исходный set множества с числами");
        System.out.println(set);

        List<Integer> list = new LinkedList<>(set);
        Collections.sort(list);

        Set<Integer> sortSet = new LinkedHashSet<>(list);

        System.out.println("Вывод отсортированного set множества с числами");
        System.out.println(sortSet);

    }
}
