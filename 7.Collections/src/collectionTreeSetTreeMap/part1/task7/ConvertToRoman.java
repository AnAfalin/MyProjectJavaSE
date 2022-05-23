package collectionTreeSetTreeMap.part1.task7;

/*
1 способ
 */

import java.util.NavigableMap;
import java.util.TreeMap;

public class ConvertToRoman {

    public void convertToRoman(int number) {
        NavigableMap<Integer, String> data = new TreeMap<>() {{
            put(1, "I");
            put(4, "IV");
            put(5, "V");
            put(9, "IX");
            put(10, "X");
            put(50, "L");
            put(90, "XC");
            put(100, "C");
            put(500, "D");
            put(900, "CM");
            put(1000, "M");
        }};

        int numberArabic = number;

        StringBuilder result = new StringBuilder();

        while (number != 0) {
            int value = data.floorKey(number);
            result.append(data.get(value));
            number -= value;
        }

        System.out.println("Число арабскими цифрами - " + numberArabic + " == Число римскими цифрами - " + result);
    }
}


