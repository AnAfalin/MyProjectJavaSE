package generalCollectionTasks.task7;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    private static final Map<String, String> rus_eng = new HashMap<>();

    static {
        firstFullDictionary();
    }

    public String search(String wordRus){

        if(rus_eng.containsKey(wordRus.toLowerCase())){
            return rus_eng.get(wordRus);
        }
        return null;
    }

    public void add(String wordRus, String wordEng){
        if(!rus_eng.containsKey(wordRus)) {
            rus_eng.put(wordRus, wordEng);
        }
    }

    private static void firstFullDictionary(){
        rus_eng.put("мужчина", "man");
        rus_eng.put("женщина", "woman");
        rus_eng.put("музыка", "music");
        rus_eng.put("машина", "car");
        rus_eng.put("самолёт", "airplane");
        rus_eng.put("цветок", "flower");
        rus_eng.put("кинотеатр", "cinema");
        rus_eng.put("фильм", "film");
        rus_eng.put("небо", "sky");
        rus_eng.put("море", "sea");
        rus_eng.put("солнце", "sun");
        rus_eng.put("вода", "water");
        rus_eng.put("сок", "juice");
        rus_eng.put("виноград", "grape");
        rus_eng.put("лимон", "lemon");
        rus_eng.put("апельсин", "orange");
        rus_eng.put("компьютер", "computer");
        rus_eng.put("кофе", "coffee");
        rus_eng.put("чай", "tea");
        rus_eng.put("кафе", "cafe");
        rus_eng.put("телевизор", "TV");
        rus_eng.put("любовь", "love");
        rus_eng.put("телефон", "telephone");
        rus_eng.put("ночь", "night");
        rus_eng.put("утро", "morning");
        rus_eng.put("день", "afternoon");
        rus_eng.put("шоклад", "chocolate");
        rus_eng.put("дом", "house");
        rus_eng.put("отель", "hotel");
        rus_eng.put("яблоко", "apple");
    }

}
