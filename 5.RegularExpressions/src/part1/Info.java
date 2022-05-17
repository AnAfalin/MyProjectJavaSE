package part1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Info {
    //Matcher:

    //boolean matches(): возвращает true, если вся строка совпадает с шаблоном
    //boolean find(): возвращает true, если в строке есть подстрока, которая совпадает с шаблоном, и переходит к этой подстроке
    //String group(): возвращает подстроку, которая совпала с шаблоном в результате вызова метода find. Если совпадение отсутствует, то метод генерирует исключение IllegalStateException.
    //int start(): возвращает индекс текущего совпадения
    //int end(): возвращает индекс следующего совпадения после текущего
    //String replaceAll(String str): заменяет все найденные совпадения подстрокой str и возвращает измененную строку с учетом замен

    public static void main(String[] args) {

        //Создание объекта класса Pattern c помощью метода compile
        //Метод compile() возвращает объект Pattern
        Pattern pattern = Pattern.compile("[A-Za-z]{4,}");

        //метод matcher(String input), который в качестве параметра принимает строку, где дальше проводится поиск, и возвращает объект Matcher
        String input = "Hello world! Hello Java! World of programming is interesting!";
        Matcher matcher = pattern.matcher(input);

        boolean found = matcher.matches();
        if(found)
            System.out.println("Вся строка совпадает с шаблоном");
        else
            System.out.println("Вся строка не совпадает с шаблоном");


        while(matcher.find())
            System.out.println(matcher.group());

        Pattern pattern1 = Pattern.compile("\\b[A-Za-z]{1,2}\\b");
        Matcher matcher1 = pattern1.matcher(input);

        String newStr = matcher1.replaceAll("--");

        System.out.println(newStr);

        String newNewStr = input.replaceAll("\\b[A-Za-z]{5}\\b", "--");
        System.out.println(newNewStr);
        System.out.println(input);


        Pattern pattern2 = Pattern.compile("Java");
        String[] words = pattern2.split(input);
        for(String word:words)
            System.out.println(word);
    }
}

