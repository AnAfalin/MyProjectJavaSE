package string;

public class TaskString {

    public static void task1(String string) {
        for (int i = 0; i < string.length(); i++) {
            System.out.print(string.charAt(i) + " ");
        }
        System.out.println();
    }

    public static void task2(String string) {
        int index = string.lastIndexOf(".");
        String titleFile = string.substring(0, 8);
        String extensionFile = string.substring(9);
    }

    public static String[] task3(String[] array) {
        int size = 0;
        for (String s : array) {
            if (s.contains("txt")) {
                size++;
            }
        }

        String[] newArray = new String[size];
        int i = 0;
        while (i < newArray.length) {
            for (String s : array) {
                if (s.contains("txt")) {
                    newArray[i] = s;
                    i++;
                }
            }
        }
        return newArray;
    }

    public static String[] task4(String[] array) {
        int size = 0;
        for (String s : array) {
            if (s.contains("txt")) {
                size++;
            }
        }

        String[] newArray = new String[size];
        int i = 0;
        while (i < newArray.length) {
            for (String s : array) {
                if (s.contains("txt")) {
                    newArray[i] = s.substring(0, s.lastIndexOf("."));
                    i++;
                }
            }
        }
        return newArray;
    }

    public static String task5() {
        return "1".repeat(100);
    }

    public static String task6v1(int count){
        String string = "123".repeat(count);
        int index = string.indexOf("3");
        String str = string.substring(0, index + 1) + string.substring(index + 1).replace("3", "");
        return str;
    }

    public static StringBuilder task6v2(int count) {
        StringBuilder stringBuilder = new StringBuilder("123".repeat(count));
        for (int i = stringBuilder.indexOf("3") + 1; i < stringBuilder.length(); i++) {
            if(stringBuilder.charAt(i) == '3') {
                stringBuilder.deleteCharAt(i);
            }
        }
        return stringBuilder;
    }

    public static String task7(int[] array) {
        String str = "";
        for (int i = 0; i < array.length; i++) {
            str += array[i] + " ";
        }
        return str;
    }

    public static void task8(String str1, String str2, String str3) { //"яблоко", "яблоко", "мандарин"
        String[] array = new String[3];
        if(str1.compareTo(str2) < 0 && str1.compareTo(str3) < 0) {
            array[0] = str1;
            if(str2.compareTo(str3) < 0) {
                array[1] = str2;
                array[2] = str3;
            }else {
                array[2] = str2;
                array[1] = str3;
            }
        }else if(str2.compareTo(str1) < 0 && str2.compareTo(str3) < 0) {
            array[0] = str2;
            if(str1.compareTo(str3) < 0) {
                array[1] = str1;
                array[2] = str3;
            }else {
                array[2] = str1;
                array[1] = str3;
            }
        }else if(str3.compareTo(str1) < 0 && str3.compareTo(str2) < 0) {
            array[0] = str3;
            if(str1.compareTo(str2) < 0) {
                array[1] = str1;
                array[2] = str2;
            }else {
                array[2] = str1;
                array[1] = str2;
            }
        }
        for (String el:array) {
            System.out.println(el);
        }
    }

    public static void task9(String string, String substring){
        int count = 0;
        int index = 0;
        while (string.indexOf(substring, index) >= 0) {

            index += string.indexOf(substring, index) + substring.length();
            count++;
        }

        System.out.println(count);
    }

    public static String task10(String string, String sign,  int count){
        int c = count;
        StringBuilder s = new StringBuilder(string);
        int index = 0;
        while (c!=0) {
             index = string.indexOf(sign);
             s.deleteCharAt(index);
             c--;
        }
        return s.toString();
    }

    public static String task11(String string){
        char[] arr = new char[string.length()];
        for (int i = 0; i < arr.length ; i++) {
            arr[i] = string.charAt(string.length() - 1 - i);
        }
        String str = "";
        for (int i = 0; i < arr.length; i++) {
            str += arr[i];
        }
        return str;
    }

    public static String[] task12(String string){
        return string.split("[\s!,.]");
    }

}
