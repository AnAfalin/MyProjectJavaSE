package additionalToolsCollections.part1.task1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Main{
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(List.of(0, 1, 2, 3, 4, 5));
        Set<Integer> set2 = new HashSet<>(List.of(0, 1, 2, 6, 7, 8));
        Set<Integer> result1 = new SetMethods().exclusive1(set1, set2);
        Set<Integer> result2 = new SetMethods().exclusive2(set1, set2);

        System.out.println("Исходное первое множество\n" + set1);
        System.out.println("Исходное второе множество\n" + set2);
        System.out.println("Результат симметричной разности множеств\n" + result1);
        System.out.println("Результат симметричной разности множеств\n" + result2);
    }
}