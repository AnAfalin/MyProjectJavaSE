package collectionTreeSetTreeMap.part1;

import java.util.TreeSet;

public class Info {
    //add - Добавляет указанный элемент к этому набору, если он еще не присутствует.
    //remove - удалить элемент
    //clear - очистить весь treeSet
    //first - Возвращает первый (самый низкий) элемент, находящийся в этом отсортированном наборе.
    //last - Возвращает последний (самый высокий) элемент, находящийся в этом отсортированном наборе.

    //subSet(x, y) - возвращает все элементы от x включительно до y невключительно
    //headSet(х) - возвращает элементы, которые меньше х
    //tailSet(х) - возвращает всеэлементы, которые больше или равны х

    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i <= 10; i++) {
            treeSet.add(i / 2);
        }
        System.out.println(treeSet);
    }
}
