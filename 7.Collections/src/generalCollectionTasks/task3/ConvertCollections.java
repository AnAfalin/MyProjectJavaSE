package generalCollectionTasks.task3;

import collectionTreeSetTreeMap.part1.task7.ConvertToRoman;

import java.util.*;


public final class ConvertCollections {

    public static <T> LinkedList<T> convertToLinkedList(HashSet<T> hashSet){
        return new LinkedList<>(hashSet);
    }

    public static <K> Map<K, Integer> convertToMap(ArrayList<K> arrayList){
        Map<K, Integer> map = new HashMap<>();
        for (K el:arrayList) {
            if (map.containsKey(el)) {
                map.put(el, map.get(el) + 1);
            }else {
                map.put(el, 1);
            }
        }
        return map;
    }
}

class Main{
    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>(Set.of(10, 20, 30, 40, 50, 60, 70, 80, 90));
        LinkedList<Integer> list = ConvertCollections.convertToLinkedList(hashSet);
        for (Integer el:list) {
            System.out.print(el + " ");
        }

    }
}
