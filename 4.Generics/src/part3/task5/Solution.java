package part3.task5;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void sumArea(Figure...args){
        int sumElementsCircle = 0;
        int sumElementsSquare = 0;
        int sumElementsTriangle = 0;
        for (Figure el:args) {
            if(el instanceof Circle){
                sumElementsCircle++;
            }
            if (el instanceof Square){
                sumElementsSquare++;
            }
            if (el instanceof Triangle){
                sumElementsTriangle++;
            }
        }
        System.out.printf("Количество объеков класса Square: %d, объеков класса Circle: %d, объеков класса Triangle: %d", sumElementsSquare, sumElementsCircle, sumElementsTriangle);
    }


    public static void main(String[] args) {
        sumArea(new Square(5), new Circle(5), new Triangle(4,4,4), new Circle(8));
    }
}
