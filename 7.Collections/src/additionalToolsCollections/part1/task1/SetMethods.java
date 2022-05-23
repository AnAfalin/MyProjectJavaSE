package additionalToolsCollections.part1.task1;

import java.util.HashSet;
import java.util.Set;

public class SetMethods {

    //1 способ
    public <T> Set<T> exclusive1(Set<T> set1, Set<T> set2){
        Set<T> newSet = new HashSet<>();

        for (T el:set1) {
            if(!(set2.contains(el))){
                newSet.add(el);
            }
        }

        for (T el:set2) {
            if(!(set1.contains(el))){
                newSet.add(el);
            }
        }

        return newSet;
    }

    //2 способ
    public <T> Set<T> exclusive2(Set<T> set1, Set<T> set2){
        //set1: 0 1 2 3 4 5
        //set2: 0 1 2 6 7 8

        Set<T> newSet = new HashSet<>();
        newSet.addAll(set1); //добавление всех элементов из первого множества
        //newSet: 0 1 2 3 4 5

        newSet.addAll(set2); //добавление всех элементов из второго множества
        //newSet: 0 1 2 3 4 5 6 7 8

        set1.retainAll(set2); //удаление из первого множества элементов, которые НЕ содержатся во втором
        //set1: 0 1 2

        newSet.removeAll(set1); //удаление из множества тех элементов, которые содержатся во первом
        //newSet: 3 4 5 6 7 8

        return newSet;
    }
}


