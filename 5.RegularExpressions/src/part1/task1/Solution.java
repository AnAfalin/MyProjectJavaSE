package part1.task1;

import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {

        //шаблон, ищущий все 5-буквенные слова
        Pattern patternTask1 = Pattern.compile("\\b.{5}\\b");

        //шаблон, ищущий все слова от 2 до 5 букв
        Pattern patternTask2 = Pattern.compile("\\b.{2,5}\\b");

        // шаблон, который ищет все 5-буквенные слова (но состоит только из букв, без цифр и прочего).
        Pattern patternTask3 = Pattern.compile("\\b[A-Za-zА-Яа-я]{5}\\b");
    }
}
