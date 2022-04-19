package part1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task5 {
    public static void main(String[] args) {

        //валидатор для email:
        //сначала идет последовательность символов от 1 до 10,
        //потом @, потом набор (mail | gmail |yandex), потом точка, в конце – (ru | com)

        String str = "info@mail.ru support@yandex.ru info@gmail.ru k-k@yandex.com info@gmail.com";

        Pattern pattern = Pattern.compile("[\\w-]{1,10}@((mail|yandex)\\.ru)|(gmail\\.com)");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
