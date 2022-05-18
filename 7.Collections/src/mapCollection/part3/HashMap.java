package mapCollection.part3;

import java.util.Arrays;
import java.util.LinkedList;

public class HashMap<K, V> {
    private static final double DEFAULT_LOAD_FACTOR = 0.75;

    private LinkedList<Entry<K, V>>[] table; //хеш-таблица, реализованная на основе массива, для хранения пар «ключ-значение» в виде узлов. Здесь хранятся Node
    private int size; //текущее количество пар «ключ-значение»
    private int capacity; //максимальное количество «ключ-значение»

    static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }

    @SuppressWarnings("unchecked")
    public HashMap() {
        capacity = 50;
        table = new LinkedList[capacity];
        for (int i = 0; i < table.length; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public void put(K key, V value) {
        if((double)size/capacity >= DEFAULT_LOAD_FACTOR){
            rehash();
        }
        put(table, key, value);
    }

    public void remove(K key){
        int indexOfTable = (capacity - 1) & key.hashCode();
        int indexDelete = getIndexLinkedList(indexOfTable, key);
        if(indexDelete != -1) {
            table[indexOfTable].remove(indexDelete);
            size--;
        }
    }

    public Entry<K, V> get(K key){
        int indexOfTable = (capacity - 1) & key.hashCode();
        int foundIndex = getIndexLinkedList(indexOfTable, key);
        if(foundIndex != -1){
            return table[indexOfTable].get(foundIndex);
        }
        return null;
    }

    public boolean containsKey(K key){
        int indexOfTable = (capacity - 1) & key.hashCode();
        return (getIndexLinkedList(indexOfTable, key) != -1);
    }

    public boolean contains(K key, V value){
        int indexOfTable = (capacity - 1) & key.hashCode();
        int index = getIndexLinkedList(indexOfTable, key);
        if(index != -1){
            return table[indexOfTable].get(index).value.equals(value);
        }
        return false;
    }

    public boolean replace(K key, V value){
        int indexOfTable = (capacity - 1) & key.hashCode();
        int index = getIndexLinkedList(indexOfTable, key);
        if(index != -1){
            table[indexOfTable].get(index).value = value;
            return true;
        }
        return false;
    }

    private void put(LinkedList<Entry<K, V>>[] linkedLists, K key, V value) {
        Entry<K, V> entry = new Entry<>(key, value);
        int index = (capacity - 1) & key.hashCode();

        int currentKeyHashCode = key.hashCode();
        boolean isDuplicate = false;
        for (Entry<K, V> el : linkedLists[index]) {
            int nextKeyHashCode = el.key.hashCode();
            if (nextKeyHashCode == currentKeyHashCode && el.equals(key)) {
                isDuplicate = true;
                break;
            }
        }

        if (!isDuplicate) {
            linkedLists[index].add(entry);
        }

        size++;

        //Только в том случае, если в ячейке не пусто (размер списка != 0)
        //hash code - уникальное значение
        //1) HC1 != HC2 - объекты разные: добавляем элемент в конец связного списка
        //2) HC1 == HC2 - ничего не известно

        //equals - сравнение полей
        //1) true - объекты идентичные, дубликат не добавляем
        //2) false - объекты разные, добавляем в конец связного списка
    }

    private int getIndexLinkedList(int index, K key){
        for (int i = 0; i < table[index].size(); i++) {
            if(key.hashCode() == table[index].get(i).key.hashCode()){
                return i;
            }
        }
        return -1;
    }

    @SuppressWarnings("unchecked")
    private void rehash() {
        System.out.println(this);
        this.capacity *= 2;
        this.size = 0;
        LinkedList<Entry<K, V>>[] temp = new LinkedList[capacity];
        for(int i=0; i<temp.length; i++){
            temp[i] = new LinkedList<>();
        }
        for (LinkedList<Entry<K, V>> linkedList : table) {
            for (Entry<K, V> el : linkedList) {
                put(temp, el.key, el.value);
            }
        }
        table = temp;
        System.out.println("rehash");
    }

    @Override
    public String toString() {
        return Arrays.toString(table);
    }
}


