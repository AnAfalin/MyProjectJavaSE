package part4.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
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
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list = List.of(1, 10, 5);
        Optional<Double> result1 = max(list1);
        Optional<Double> result = max(list);

        if(result.isPresent()){
            System.out.println(result.get());
        }else {
            throw new NoSuchElementException("null element");
        }

        result1.ifPresentOrElse(System.out::println, ()-> System.out.println("null element"));

        System.out.println(result1.orElseThrow());

    }
}
