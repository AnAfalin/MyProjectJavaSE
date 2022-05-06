package ArrayListCollection.part1;

import java.util.Collections;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();//создания списка

        //добавленияе элементов
        list.add(10);
        list.add(20);
        list.add(40);

        System.out.println(list);

        //добавление в начало
        list.addFirst(0);

        //добавление по индексу
        list.add(30, 3);

        System.out.println(list);

        //удаление первого элемента
        list.deleteFirst();

        //удаление последнего элемента
        list.deleteLast();

        //удаление элемента по индексу
        list.delete(-5);

        System.out.println(list);

        System.out.println(list.contains(10));

        ArrayList<Integer> list2 = new ArrayList<>();//создания списка #2 и добавление элементов
        list.add(55);
        list.add(66);
        list.add(77);

        //добавление всех элементов из списка #2 в список #1
        list.addAll(list2);

        System.out.println(list);

    }
}
