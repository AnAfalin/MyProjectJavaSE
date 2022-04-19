package part1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {
    public static void main(String[] args) {
        //шаблон, находящий все числа (и дроби тоже)
        String str = "-20 0.50 5.0 1, 1. .005 255 230.55 5,5";

        Pattern pattern = Pattern.compile("[-]?[.,]?\\d+([.,]?\\d)*");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
