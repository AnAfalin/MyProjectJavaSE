package part2.task4;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static double sumArea(List<? extends Figure> list){
        double sum = 0;
        for (Figure element:list) {
            sum +=element.calculateArea();
        }
        return sum;
    }


    public static void main(String[] args) {
        List<Figure> list = new ArrayList<>();
        list.add(new Square(5.0));
        list.add(new Circle(1.0));
        list.add(new Triangle(2, 2, 1));
    }
}
