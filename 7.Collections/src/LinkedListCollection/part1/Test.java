package LinkedListCollection.part1;

public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(30);
        list.addLast(40);
        list.addLast(60);
        list.addLast(70);
        System.out.println(list);
        list.add(50, 2);
        System.out.println(list);
        list.deleteFirst();

        System.out.println(list);

        list.delete(2);
        System.out.println(list);
    }
}
