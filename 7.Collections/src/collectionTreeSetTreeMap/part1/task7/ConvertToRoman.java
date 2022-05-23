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
            if (number > data.lastKey()) {
                result.append(data.get(data.lowerKey(number)));
                number -= data.lowerKey(number);
            } else if (data.containsKey(number)) {
                result.append(data.get(number));
                number -= number;
            } else if (Math.abs(data.lowerKey(number) - number) < Math.abs(data.higherKey(number) - number)) {
                result.append(data.get(data.lowerKey(number)));
                number -= data.lowerKey(number);
            } else if ((Math.abs(data.lowerKey(number) - number) >= Math.abs(data.higherKey(number) - number)) && (Math.abs(data.higherKey(number) - number) == 1 || Math.abs(data.higherKey(number) - number) == 10 || Math.abs(data.higherKey(number) - number) == 100)) {
                result.append(data.get(data.lowerKey(number / 2)));
                number += data.lowerKey(data.lowerKey(number));
            } else if (Math.abs(data.lowerKey(number) - number) >= Math.abs(data.higherKey(number) - number)) {
                result.append(data.get(data.lowerKey(number)));
                number -= data.lowerKey(number);
            }
        }

        System.out.println("Число арабскими цифрами - " + numberArabic + "\nЧисло римскими цифрами - " + result);
    }
}


