package part2.task3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Solution {
    public static void main(String[] args) {
        Auto auto = new Auto();
        try {
            Method setBrand = auto.getClass().getDeclaredMethod("setBrand", String.class);
            setBrand.invoke(auto, "BMW");
            Object autoString = auto.getClass().getDeclaredMethod("toString").invoke(auto);
            System.out.println(autoString);

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
