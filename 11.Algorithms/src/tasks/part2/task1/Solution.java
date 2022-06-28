package tasks.part2.task1;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String str = "Java. Now is June. Now is Summer";
        Character symbol = firstSymbolString(str, getMapSymbol(str));
        System.out.println(symbol);

    }

    //O(n)
    public static Character firstSymbolString(String str, Map<Character, Integer> mapSymbol) {
        Character symbol;
        for (int i = 0; i < str.length(); i++) {        //O(n)
            symbol = str.charAt(i);                     //O(1)
            if (mapSymbol.get(symbol) == 1) {           //O(1)
                return symbol;
            }
        }
        return null;
    }


    public static Map<Character, Integer> getMapSymbol(String str) {
        Map<Character, Integer> mapSymbol = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            if (mapSymbol.containsKey(str.charAt(i))) {
                mapSymbol.put(str.charAt(i), mapSymbol.get(str.charAt(i)) + 1);
            } else {
                mapSymbol.put(str.charAt(i), 1);
            }
        }
        return mapSymbol;
    }
}
