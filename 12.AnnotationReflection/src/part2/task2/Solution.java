package part2.task2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Solution {
    public static <T> void test(T object) {
        System.out.println("Название класса объекта: " + object.getClass().getName());
        System.out.println("Названия всех методов");
        Arrays.stream(object.getClass().getDeclaredMethods()).forEach(method -> System.out.println(method.getName()));
        try {
            Method equals = object.getClass().getDeclaredMethod("equals", Object.class);
            Object invoke = equals.invoke(object, 5);
            System.out.println(invoke);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        long countMethods = Arrays.stream(object.getClass().getDeclaredMethods()).count();
        long countPublicMethods = Arrays.stream(object.getClass().getDeclaredMethods()).filter(method -> method.getModifiers() == Modifier.PUBLIC).count();
        long countPrivateMethods = Arrays.stream(object.getClass().getDeclaredMethods()).filter(method -> method.getModifiers() == Modifier.PRIVATE).count();
        System.out.println("Количество все методов " + countMethods);
        System.out.println("Количество public методов " + countPublicMethods + ", а количество всех остальных " + (countMethods - countPublicMethods));
        System.out.println("Количество private методов " + countPrivateMethods);

    }

    public static void main(String[] args) {
        Integer integer = 5;
        test(integer);
    }
}
