package collectionTreeSetTreeMap.part1.task6;

public class Solution {
    public static void main(String[] args) {
        //поиск в TreeSet - O(log(n))
        //поиск в HashSet - O(n)

        int n = 16;
        compareSearchSpeed(n);
    }

    public static void compareSearchSpeed(int n){
        double speedTreeSet = Math.log(n) / Math.log(2);
        double speedHashSet = n;
        System.out.println("Скорость поиска элемента в TreeSet = " + speedTreeSet);
        System.out.println("Скорость поиска элемента в HashSet = " + speedHashSet);//10_000_000
        System.out.println("Скорость поиска элемента в TreeSet быстрее поиска в HashSet в " + speedHashSet / speedTreeSet + " раз");
    }
}
