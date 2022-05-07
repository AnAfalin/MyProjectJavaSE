package LinkedListCollection.part1;

public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(30);
        list.addLast(40);
        list.addLast(50);
        list.add(8, 1);
        System.out.println(list);
    }
}
