package part2.task1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;


public class Solution {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        Method[] declaredMethods = list.getClass().getDeclaredMethods();
        int countNotVoidMethods = 0;
        int number = 0;
        for (Method declaredMethod : declaredMethods) {
            System.out.println(number);
            System.out.println("Class: " + declaredMethod.getClass());
            System.out.println("Method name: " + declaredMethod.getName());
            System.out.println("Return type: " + declaredMethod.getReturnType());
            System.out.println("Parameters: " + Arrays.toString(declaredMethod.getParameters()));
            System.out.println("---");
            number++;
            if (declaredMethod.getReturnType() != Void.TYPE) {
                countNotVoidMethods++;
            }
        }


        System.out.println("количество не-void методов в классе: " + countNotVoidMethods);

        try {
            list.getClass().getDeclaredMethod("addFirst", int.class).invoke(list, 200);
            list.getClass().getDeclaredMethod("addFirst", int.class).invoke(list, 300);
            list.getClass().getDeclaredMethod("print");

            Method method = list.getClass().getDeclaredMethod("isCheckIndex", int.class);
            method.setAccessible(true);
            Boolean res = (Boolean) method.invoke(list,5);
            System.out.println(res);

        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }


    }

}
