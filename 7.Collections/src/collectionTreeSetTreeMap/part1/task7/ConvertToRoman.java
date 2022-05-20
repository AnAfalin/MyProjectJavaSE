package collectionTreeSetTreeMap.part1.task7;

import java.util.NavigableMap;
import java.util.TreeMap;

public class ConvertToRoman {

    public void convertToRoman(int number) { //1
        NavigableMap<Integer, Character> dataArabicRoman = new TreeMap<>() {{
            put(1, 'I');
            put(5, 'V');
            put(10, 'X');
            put(50, 'L');
            put(100, 'C');
            put(500, 'D');
            put(1000, 'M');
        }};

        StringBuilder result = new StringBuilder();
        do{
            if(dataArabicRoman.containsKey(number)){
                result.append(dataArabicRoman.get(number));
                number -= dataArabicRoman.ceilingKey(number);
            }
        }while (number != 0);


        System.out.println(result);

    }





}


