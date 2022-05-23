package collectionTreeSetTreeMap.part1.task7;

/*
2 способ
 */

import java.util.NavigableMap;
import java.util.TreeMap;

public class ConvertToRoman1 {

    public void convertToRoman(int number) {
        NavigableMap<Integer, String> data = new TreeMap<>() {{
            put(1, "I");
            put(5, "V");
            put(10, "X");
            put(50, "L");
            put(100, "C");
            put(500, "D");
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
            } else if (Integer.toString(number).charAt(0) == '4'){
                result.append(data.get(data.lowerKey(number)));
                number += data.lowerKey(number);
            } else if (Integer.toString(number).charAt(0) == '9'){
                result.append(data.get(data.lowerKey(data.lowerKey(number))));
                number += data.lowerKey(data.lowerKey(number));
            } else if (Integer.toString(number).charAt(0) == '6'){
                result.append(data.get(data.higherKey(number)));
                number -= data.higherKey(number);
            }else {
                result.append(data.get(data.lowerKey(number)));
                number -= data.lowerKey(number);
            }
        }

        System.out.println("Число арабскими цифрами - " + numberArabic + " == Число римскими цифрами - " + result);
    }
}


