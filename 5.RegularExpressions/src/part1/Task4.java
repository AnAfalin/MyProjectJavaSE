package part1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task4 {
    public static void main(String[] args) {

        //шаблон, который ищет все 5-буквенные слова (но состоит только из букв, без цифр и прочего
        //аналог [-]?[0-9]+([.,][0-9]+)?
        String str = "text world bottle milk juice сахар 12345 sun one ты -20";

        Pattern pattern = Pattern.compile("\\b[A-Za-zА-Яа-я]{5}\\b");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
