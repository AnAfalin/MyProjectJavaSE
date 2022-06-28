package part4.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Solution {
    public static <T extends Number> Optional<Double> max(List<T> list){
        if(list == null || list.size() == 0){
            return Optional.empty();
        }
        double max = 0.0;
        for (T el:list) {
            max += el.doubleValue();
        }
        return Optional.of(max);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = List.of(1, 10, 5);
        if(max(list).isPresent()){
            System.out.println(max(list).get());
        }else {
            System.out.println(max(list));
        }

        list1.stream().max(Integer::compare).ifPresent(System.out::println);
    }
}
