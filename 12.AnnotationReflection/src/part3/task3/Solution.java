package part3.task3;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Solution {
    public static void main(String[] args) throws Exception {
        Class<StringJava> stringJavaClass = StringJava.class;

        Field name = stringJavaClass.getDeclaredField("name");

        name.setAccessible(true);
        System.out.println(name.get(stringJavaClass));

        name.set(stringJavaClass, "IT");
        System.out.println(name.get(stringJavaClass));

        Method doubleString = stringJavaClass.getDeclaredMethod("doubleString");
        doubleString.setAccessible(true);
        String result = (String) doubleString.invoke(null);     //т.к вызываем статический метод, то можно передавать null
        System.out.println(result);
    }
}

class StringJava {
    private static String name = "Java";

    public static String doubleString(){
        return name + " " + name;
    }
}




