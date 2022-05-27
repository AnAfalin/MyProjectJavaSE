package iteratorClass.task7;

import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(60);
        list.add(70);
        list.add(80);
        list.add(90);
        list.add(100);
        for (Integer el:list) {
            System.out.print(el + " ");
        }
        System.out.println("\nPast remove elements (el / 30 = 0) in Iterator");

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            if(iterator.next() % 30 == 0){
                iterator.remove();
            }
        }

        for (Integer el:list) {
            System.out.print(el + " ");
        }

    }
}

