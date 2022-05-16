package mapCollection.part3.task1;

import java.util.LinkedList;

public class HashMap<K, V>  {
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
        for (int i = 0; i < table.length; i++){
            table[i] = new LinkedList<>();
        }
    }

    public void put(K key, V value){
        //Только в том случае, если в ячейке не пусто (размер списка != 0)
        //hash code - уникальное значение
        //1) HC1 != HC2 - объекты разные: добавляем элемент в конец связного списка
        //2) HC1 == HC2 - ничего не известно

        //equals - сравнение полей
        //1) true - объекты идентичные, дубликат не добавляем
        //2) false - объекты разные, добавляем в конец связного списка
    }

}

class Test{
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        for (int i = 1; i < 20; i++){
            hashMap.put(i*25, Integer.toString(i*50));
        }

    }
}
