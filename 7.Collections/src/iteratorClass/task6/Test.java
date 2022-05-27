package iteratorClass.task6;

import java.util.Comparator;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();//создания списка

        //добавленияе элементов
        list.add(10);
        list.add(20);
        list.add(40);

        //добавление в начало
        list.addFirst(0);

        //добавление по индексу
        list.add(30, 3);


        for (Integer el:list) {
            System.out.println(el);
        }

    }
}
