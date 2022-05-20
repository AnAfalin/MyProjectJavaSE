package collectionTreeSetTreeMap.part1.task7;

import java.util.NavigableMap;
import java.util.TreeMap;

public class ConvertToArabic {
    public void convertToArabic(String number) {
        NavigableMap<Character, Integer> dataRomanArabic = new TreeMap<>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};

        int result = 0;
        for (int i = 0; i < number.length(); i++) {

            if (i == 0 || dataRomanArabic.get(number.charAt(i)) <= dataRomanArabic.get(number.charAt(i - 1))) {
                result += dataRomanArabic.get(number.charAt(i));
            } else {
                result += dataRomanArabic.get(number.charAt(i)) - 2 * dataRomanArabic.get(number.charAt(i - 1));
            }
        }
        System.out.println("Число арабскими цифрами - " + number + "\nЧисло римскими цифрами - " + result);
    }
}
