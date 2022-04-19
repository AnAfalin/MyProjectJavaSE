package part1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task8 {
    public static void main(String[] args) {
        //шаблон, ищущий все слова от 2 до 5 букв.
        String str = "tex7t world bottle m8ilk juice сах8ар 12345 sun one -20";
        System.out.println(str);
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(str);
        String newStr = matcher.replaceAll("[цифра]");
        System.out.println(newStr);

    }
}
