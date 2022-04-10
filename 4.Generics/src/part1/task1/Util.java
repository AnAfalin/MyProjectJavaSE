package part1.task1;

import java.util.ArrayList;
import java.util.List;

class Util {
    public static <K, V> boolean checkPassword (ArrayList<Card<K, V>> list, V number, K password) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNumber() == number) {
                return list.get(i).getPassword().equals(password);
            }
        }
        System.out.println("Искомый номер не найден.");
        return false;
    }

    public static <K, V> void printArray (ArrayList<Card<K, V>> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getNumber() + " " + list.get(i).getPassword());
        }
    }

    //метод вывода на консоль любого списка.
    public static <T> void printList (List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
    //метод добавления элемента в любой список.
    public static <T> void addInList (T element, List<T> list) {
        list.add(element);
    }

    //метод получения элемента по индексу из списка.
    public static <T> void getElement (int index, List<T> list) {
        list.get(index);
    }

    //метод, заполняющий любой список определенным элементом
    public static <T> void fillList(List<T> list, T element){
        for (int i = 0; i < list.size(); i++){
            list.add(i, element);
        }
    }
}