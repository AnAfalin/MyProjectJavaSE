package hashSetCollection.part1.task4;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        String text = "Ночь, улица, фонарь, аптека, " +
                "Бессмысленный и тусклый свет. " +
                "Живи еще хоть четверть века — " +
                "Всё будет так. Исхода нет." +
                "Умрешь — начнешь опять сначала " +
                "И повторится всё, как встарь: " +
                "Ночь, ледяная рябь канала, " +
                "Аптека, улица, фонарь.";
        HashSet<Character> hashSet = new HashSet<>();
        for (int i = 0; i < text.length(); i++) {
            hashSet.add(text.charAt(i));
        }

        System.out.println(hashSet);

        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (Character el:hashSet){
            int count = 0;
            for (int i = 0; i < text.length(); i++) {
                if(el.equals(text.charAt(i))){
                    count++;
                }
            }
            hashMap.put(el, count);
        }
        System.out.println("Символ в слове=количество повторений в тексте\n" + text);
        System.out.println(hashMap);
    }
}
