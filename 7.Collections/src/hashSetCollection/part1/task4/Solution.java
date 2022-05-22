package hashSetCollection.part1.task4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String text = "привет, мир.";
        Map<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            if(hashMap.containsKey(text.charAt(i))){
                hashMap.put(text.charAt(i), hashMap.get(text.charAt(i)) + 1);
            }else {
                hashMap.put(text.charAt(i), 1);
            }
        }

        System.out.println("Символ в слове=количество повторений в тексте\n" + text);
        System.out.println(hashMap);
    }
}
