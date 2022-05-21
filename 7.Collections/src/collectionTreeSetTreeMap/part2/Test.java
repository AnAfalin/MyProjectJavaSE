package collectionTreeSetTreeMap.part2;

import java.util.TreeMap;

public class Test {
    public static void main(String[] args) {
        MyTreeMap<Integer> myTreeMap = new MyTreeMap<>();
        myTreeMap.put(10);
        myTreeMap.put(20);
        myTreeMap.put(40);
        myTreeMap.put(15);
        System.out.println(myTreeMap.find(25));



    }
}
