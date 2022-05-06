package ArrayListCollection.part1;

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
        list.delete(1);

        System.out.println(list);

    }
}
