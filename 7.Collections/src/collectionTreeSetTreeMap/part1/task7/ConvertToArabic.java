package collectionTreeSetTreeMap.part1.task7;

import java.util.NavigableMap;
import java.util.TreeMap;

public class ConvertToArabic {
    private static final NavigableMap<Character, Integer> data = new TreeMap<>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public void convertToArabic(String number) {

        int result = 0;
        for (int i = 0; i < number.length(); i++) {

            if (i == 0 || data.get(number.charAt(i)) <= data.get(number.charAt(i - 1))) {
                result += data.get(number.charAt(i));
            } else {
                result += data.get(number.charAt(i)) - 2 * data.get(number.charAt(i - 1));
            }
        }
        System.out.println("Число римскими цифрами - " + number + "\nЧисло арабскими цифрами - " + result);
    }
}
