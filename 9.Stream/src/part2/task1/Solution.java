package part2.task1;

import java.util.Optional;

public class Solution<T extends Number> {
    public Optional<T> max(T[] array) {
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

    public Optional<T> min(T[] array) {
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

    public double sum(T[] array) {
        double sum = 0;
        for (T j : array) {
            sum +=Double.parseDouble(j.toString());
        }
        return sum;
    }

    public double average(T[] array) {
        return sum(array) / array.length;
    }

}
