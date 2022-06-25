package part2.task1;

import java.util.Optional;
import java.util.stream.Stream;


public class Solution {
    public <T extends Number> Optional<T> max(T[] array) {
        if(array == null || array.length == 0){
            return Optional.empty();
        }
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (Double.parseDouble(array[i].toString()) > Double.parseDouble(max.toString())) {
                max = array[i];
            }
        }
        return Optional.of(max);
    }

    public <T extends Number> Optional<T> min(T[] array) {
        if(array == null || array.length == 0){
            return Optional.empty();
        }
        T min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (Double.parseDouble(array[i].toString()) > Double.parseDouble(min.toString())) {
                min = array[i];
            }
        }
        return Optional.of(min);
    }

    public <T> double sum(T[] array) {
        double sum = 0;
        for (T j : array) {
            sum +=Double.parseDouble(j.toString());
        }
        return sum;
    }

    public <T> double average(T[] array) {
        return sum(array) / array.length;
    }

}
