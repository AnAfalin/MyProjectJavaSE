package collectionTreeSetTreeMap.part1.task7;

import java.util.*;

public class ConvertNumber {
    public static NavigableMap<Integer, String> treeMap = new TreeMap<>() {{
        put(1, "I");
        put(5, "V");
        put(10, "X");
        put(50, "L");
        put(100, "C");
        put(500, "D");
        put(1000, "M");
    }};

    private static void convertToRoman(int number) {
        int numberArabic = number;
        StringBuilder result = new StringBuilder();

        int thousandths = numberArabic / 1000;
        if (thousandths != 0) {
            for (int i = 1; i <= thousandths; i++) {
                result.append(treeMap.get(1000));
            }
            numberArabic = numberArabic % 1000;
        }


        int hundredths = numberArabic / 100;
        if (hundredths != 0) {
            if (treeMap.containsKey(hundredths)) {
                result.append(treeMap.get(hundredths * 100));
            } else if (hundredths == 4) {
                result.append(treeMap.get(treeMap.lowerKey(hundredths * 100))).append(treeMap.get(treeMap.higherKey(hundredths * 100)));
            } else {
                for (int i = 1; i <= hundredths; i++) {
                    result.append(treeMap.get(i));
                }
            }
            numberArabic = numberArabic % 100;

        }


        int decimal = numberArabic / 10;
        if (decimal != 0) {
            if (treeMap.containsKey(decimal)) {
                result.append(treeMap.get(decimal * 10));
            } else if (decimal == 4) {
                result.append(treeMap.get(treeMap.lowerKey(decimal * 10))).append(treeMap.get(treeMap.higherKey(decimal * 10)));
            } else {
                for (int i = 1; i <= decimal; i++) {
                    result.append(treeMap.get(i));
                }
            }
            numberArabic = numberArabic % 10;
        }


        if (numberArabic != 0) {
            if (treeMap.containsKey(numberArabic)) {
                result.append(treeMap.get(numberArabic));
            } else if (numberArabic == 4) {
                result.append(treeMap.get(treeMap.lowerKey(numberArabic))).append(treeMap.get(treeMap.higherKey(numberArabic)));
            } else {
                for (int i = 1; i <= numberArabic; i++) {
                    result.append(treeMap.get(i));
                }
            }
        }

        System.out.println("Число арабскими цифрами - " + number + "\nЧисло римскими цифрами " + result);
    }

    private static void convertToArabic(String number) {
    }















    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число арабскими цифрами");
        convertToRoman(scanner.nextInt());

        System.out.println("Введите число римскими цифрами цифрами");
        convertToArabic(scanner.nextLine());
    }
}


