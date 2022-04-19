package part1;

import java.util.regex.Pattern;

public class Task11 {
    public static void main(String[] args) {

        //валидатор для IP адреса (простой).
        String str = "255.255.255.255";
        String str1 = "122.255.255.255";
        String str2 = "122.256.255.255";
        String regex = "((1\\d{2}|2[0-4]\\d|25[0-5])\\.){3}(1\\d{2}|2[0-4]\\d|25[0-5])";
        System.out.println(str.matches(regex));
        System.out.println(str1.matches(regex));
        System.out.println(str2.matches(regex));



    }
}
