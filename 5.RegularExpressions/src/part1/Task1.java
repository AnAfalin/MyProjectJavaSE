package part1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {
    public static void main(String[] args) {
        //шаблон, ищущий все слова от 2 до 5 букв.
        String str = "text world bottle milk juice сахар 12345 sun one -20";

        Pattern pattern = Pattern.compile("\\b[A-Za-zА-Яа-я0-9]{2,5}\\b");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
