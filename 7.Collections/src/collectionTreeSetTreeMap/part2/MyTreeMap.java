package collectionTreeSetTreeMap.part2;

import java.io.StringReader;
import java.util.Arrays;

public class MyTreeMap<K extends Comparable<K>>{
    public  Entry<K> root; //корень
    public int size;

    public MyTreeMap() {
    }

    static class Entry<K> {
        K key;          //значение
        Entry<K> left;  //левый
        Entry<K> right; //правый

        public Entry(K key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return "" + key;
        }
    }

    //добавление
    public void put(K key) {
        Entry<K> newEntry = new Entry<>(key);

        if (root == null) {
            root = newEntry;
        } else {
            Entry<K> current = root;
            while (true) {
                if (key.compareTo(current.key) > 0) {
                    if(current.right == null){
                        current.right = newEntry;
                        break;
                    }
                    current = current.right;
                } else if (key.compareTo(current.key) < 0) {
                    if(current.left == null){
                        current.left = newEntry;
                        break;
                    }
                    current = current.left;
                }
            }
            size++;
        }
    }

    //удаление


    //поиск элемента
    public boolean find(K key){
        Entry<K> current = root;
        while (current.key != key) {
            if (key.compareTo(current.key) > 0) {
                current = current.right;
            } else if (key.compareTo(current.key) < 0) {
                current = current.left;
            }
            if(current == null){
                return false;
            }
        }
        return true;
    }

    private String printEl(Entry<K> entry){
        String str = "";
        if(entry.left != null){
            str += printEl(entry.left) + " ";
        }
        if(entry.right != null){
            str += printEl(entry.right) + " ";
        }
        str += entry.key;
        return str;
    }

    public void print(){
        String str = printEl(root);
        Object[] objects = str.split(" ");
        Arrays.sort(objects);
        System.out.println(Arrays.toString(objects));
    }

}
