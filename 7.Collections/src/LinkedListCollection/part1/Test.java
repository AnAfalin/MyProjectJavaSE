package linkedListCollection.part1;

public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(30);
        list.addLast(40);
        list.addLast(50);
        list.addLast(60);
        list.addLast(70);
        list.addLast(80);
        list.addLast(90);

        System.out.print("print array: ");
        Integer[] array = new Integer[list.size];
        array = list.toArray(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        list.add(50, 4);
        list.add(50, 8);
        System.out.println(list);

        list.removeAll(50);
        System.out.println(list);

        list.delete(1);
        System.out.println(list);

        System.out.println("linkedList contains 90: " + list.contains(90));
        System.out.println("linkedList contains 99: " + list.contains(99));
        System.out.println(list.sumOfAllElements());
    }
}

