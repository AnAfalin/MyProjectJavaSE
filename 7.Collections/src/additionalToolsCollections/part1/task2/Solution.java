package additionalToolsCollections.part1.task2;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            list.add(random.nextInt(101));
        }
        Collections.sort(list);
        System.out.println(list);

        System.out.println("Исходный список");

        int num = random.nextInt(101);

        int index = Collections.binarySearch(list, num); // Сложность операции O(log(n))

        System.out.println("Искомый элемент - " + num);
        if(index > 0) {
            System.out.println("Индекс искомого элемента " + index);
        }else {
            System.out.println("Искомый элемент в списке не содержится");
        }
    }
}
