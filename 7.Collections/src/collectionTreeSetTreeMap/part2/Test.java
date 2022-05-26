package collectionTreeSetTreeMap.part2;

public class Test {
    public static void main(String[] args) {
        MyTreeMap<Integer> myTreeMap = new MyTreeMap<>();
        myTreeMap.put(20);
        myTreeMap.put(15);
        myTreeMap.put(5);
        myTreeMap.put(18);
        myTreeMap.put(30);
        myTreeMap.put(25);
        myTreeMap.put(40);
        myTreeMap.put(35);
        myTreeMap.put(38);
        myTreeMap.put(45);
        myTreeMap.printTree();
        myTreeMap.delete(20);
        myTreeMap.printTree();
        myTreeMap.delete(35);
        myTreeMap.printTree();
    }
}

