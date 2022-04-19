package part1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task9 {
    public static void main(String[] args) {

        //валидатор для URL. Начинаться может как с www, так и с http (s). Заканчиваться может только на ru или com
        String str = "https://goo.ru www.mail.ru http://yandex.ru www.google.com mail.ru www.rambler.com";

        Pattern pattern = Pattern.compile("(www\\.|http[s]?://)[A-Za-z0-9]+\\.(ru|com)");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
