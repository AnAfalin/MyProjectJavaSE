package part2.task4;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static <T> void test(T object) {
        List<Method> methods = Arrays.stream(object.getClass().getDeclaredMethods()).filter(Method::isBridge).toList();
        System.out.println(methods);
    }

    public static void main(String[] args) {
        Integer integer = 5;
        test(integer);
    }
}
