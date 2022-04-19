package part1;

import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        //шаблон, ищущий все 5-буквенные слова
        Pattern pattern1 = Pattern.compile("\\b[\\wА-я0-9]{5}\\b");

        //шаблон, ищущий все слова от 2 до 5 букв.
        Pattern pattern2 = Pattern.compile("\\b[\\wА-я0-9]{2,5}\\b");

        //шаблон, который ищет все 5-буквенные слова (но состоит только из букв, без цифр и прочего
        Pattern pattern3 = Pattern.compile("\\b[A-Za-zА-Яа-я]{5}\\b");

        //шаблон, находящий все числа (и дроби тоже)
        Pattern pattern4 = Pattern.compile("[-]?\\d+([.,]?\\d)*");

        //валидатор для email:
        //сначала идет последовательность символов от 1 до 10,
        //потом @, потом набор (mail | gmail |yandex), потом точка, в конце – (ru | com)
        Pattern pattern5 = Pattern.compile("^[\\w\\.]{1,10}@(mail|yandex|gmail).(ru|com)");

        //шаблон, ищущий любые слова, но в которых нет дефиса
        Pattern pattern6 = Pattern.compile("");

        //валидатор для URL. Начинаться может как с www, так и с http (s). Заканчиваться может только на ru или com
        Pattern pattern9 = Pattern.compile("(www|http[s]?)((.)|(://))[A-Za-z0-9]+\\.(ru|com)");

        //валидатор для номера банковской карты
        Pattern pattern10 = Pattern.compile("((\\d{4})\\s){4}?\\d{4}");

        //валидатор для IP адреса (простой).
        Pattern pattern11 = Pattern.compile("(1\\d{0,2}|22[0-3]|2[0-2][0-3]).(1\\d{0,2}|2[0-1]\\d|22[0-5]).(1\\d{0,2}|2[0-1]\\d|22[0-5]).(1\\d{0,2}|2[0-1]\\d|22[0-5])");



    }
}
