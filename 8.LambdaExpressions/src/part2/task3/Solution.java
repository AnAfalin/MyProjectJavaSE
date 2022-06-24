package part2.task3;

import java.util.function.*;

public class Solution {
    public static void main(String[] args) {
        /*
        Виды ссылок на методы:
            Ссылка на статический метод через название класса;
            Ссылка на нестатический метод через экземпляр класса;
            Ссылка на нестатический метод через название класса;
            Ссылка на конструктор.
         */

        //Ссылка на статический метод через название класса
        BiFunction<Integer, Integer, Double> pow = Math::pow; //(x, y) -> Math.pow(x, y)
        int number = 5;
        int degree = 2;
        double powNumber = pow.apply(number, degree);

        //Ссылка на нестатический метод через экземпляр класса
        //аргумент из лямбда-выражения (x) не изменяется -> можно заменить лямбду на ссылку на метод
        String str = "Java";
        Predicate<String> function = str::equals;    //x -> x.length()

        //Ссылка на нестатический метод через название класса
        //параметр лямбда (x) используется только для вызова метода из класса String -> можно заменить на ссылку на метод:
        Function<Integer, Double > unaryOperator = Integer::doubleValue;    //x -> x.doubleValue()

        //Ссылка на конструктор
        //вызывается определенный конструктор -> можно заменить на ссылку
        BiFunction<String, String, WordRusEng> newWord = WordRusEng::new; //(rus, eng) -> new WordRusEng(rus, eng)

    }
}

class WordRusEng{
    String rusWord;
    String engWord;

    public WordRusEng(String rusWord, String engWord) {
        this.rusWord = rusWord;
        this.engWord = engWord;
    }
}
