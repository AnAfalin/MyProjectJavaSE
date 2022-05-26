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
            return;
        }

        Entry<K> current = root;
        while (true) {
            if (key.compareTo(current.key) > 0) {
                if (current.right == null) {
                    current.right = newEntry;
                    break;
                }
                current = current.right;
            } else if (key.compareTo(current.key) < 0) {
                if (current.left == null) {
                    current.left = newEntry;
                    break;
                }
                current = current.left;
            } else {
                return;
            }
        }
        size++;
    }

    //удаление
    public void delete(K key) {
        if (root == null) {
            return;
        }

        Entry<K> parent = root;
        Entry<K> current = root;

        while (current.key != key) {
            parent = current;
            if (key.compareTo(current.key) > 0) {
                current = current.right;
            } else if (key.compareTo(current.key) < 0) {
                current = current.left;
            }
            if(current == null){
                return;
            }
        }

        if (current.left == null && current.right == null) {   //если у корня нет потомков
            if(root == current){
                root = null;
            }
            else if (parent.left == current) {
                parent.left = null;
            } else if (parent.right == current) {
                parent.right = null;
            }
        } else if (current.left == null || current.right == null) {   //если у корня один потомок
            if(current.right == null){
                if(root == current){
                    root = current.left;
                }
                else {
                    if (parent.left == current) {
                        parent.left = current.left;
                    } else if (parent.right == current) {
                        parent.right = current.left;
                    }
                }
            }
            else {
                if(root == current){
                    root = current.right;
                }
                else if (parent.left == current) {
                    parent.left = current.right;
                } else if (parent.right == current) {
                    parent.right = current.right;
                }
            }
        } else {
            //если два потомка
            Entry<K> successor = getSuccessor(current);

            if (successor != current.right) {
                current.right.left = successor.right;
                successor.right = current.right;
            }
            if(root == current){
                root = successor;
            }
            else if(parent.left == current){
                parent.left = successor;
            }
            else {
                parent.right = successor;
            }
            successor.left = current.left;

        }
        size--;
    }

    private Entry<K> getSuccessor(Entry<K> delNode) {
        Entry<K> successor = delNode;
        Entry<K> current = delNode.right;
        while (current != null) {
            successor = current;
            current = current.left;
        }
        return successor;
    }

    //поиск элемента
    public boolean found(K key){
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

    public void print(){
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Entry<K> localEntry){
        if(localEntry == null){
            return;
        }
        inOrder(localEntry.left);
        System.out.print(localEntry.key);
        System.out.print(" ");
        inOrder(localEntry.right);
    }

    public void printTree(){
        BinaryTreePrinter.printNode(root);
    }
}
