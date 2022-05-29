package generalCollectionTasks.task7;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Dictionary dictionaryRusEng = new Dictionary();
        System.out.println("<<Русско-Английский словарь. Для выхода из словара необходимо ввести \"EXIT\">>");

        while (true){

            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите слово на русском для перевода на английский");
            if(scanner.hasNext("EXIT|exit")){
                break;
            }

            String wordRus = scanner.nextLine().toLowerCase();

            String wordEng = dictionaryRusEng.search(wordRus);
            if(wordEng != null){
                System.out.println(wordEng);
            }else {
                System.out.println("Перевод данного слова отсутствует в словаре.");
                System.out.println("Добавить это слово в словарь? Yes/No");
                if(scanner.nextLine().equalsIgnoreCase("Yes")){
                    System.out.println("Введите его перевод на английском");
                    dictionaryRusEng.add(wordRus, scanner.nextLine().toLowerCase());
                }
            }
        }
    }
}
