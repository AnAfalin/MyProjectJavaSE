package collectionTreeSetTreeMap.part2;

public class Test {
    public static void main(String[] args) {
        MyTreeMap<Integer> myTreeMap = new MyTreeMap<>();
        myTreeMap.put(10);
        myTreeMap.put(20);
        myTreeMap.put(40);
        myTreeMap.put(15);
        myTreeMap.put(50);
        myTreeMap.print();
        System.out.println(myTreeMap.find(25));
        myTreeMap.delete(20);
        myTreeMap.print();
        myTreeMap.delete(10);
        myTreeMap.print();



    }
}
