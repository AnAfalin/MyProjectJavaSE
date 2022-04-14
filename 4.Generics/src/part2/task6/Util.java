package part2.task6;

import java.util.ArrayList;
import java.util.List;

public class Util <T extends Number>{
    public static int compareSumLists(List<? extends  Number> list1, List<? extends  Number> list2) {
        double sumListFirst = sumElementOfListT(list1);
        double sumListSecond = sumElementOfListT(list2);
        return Double.compare(sumListFirst, sumListSecond);
    }

    private static <T extends Number> double sumElementOfListT (List<T> list){
        double sum = 0;
        for (Number el : list) {
            sum += el.doubleValue();
        }
        return sum;
    }
}

class Main{
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Double> list2 = new ArrayList<>();

        list1.add(10);
        list1.add(20);
        list1.add(30);
        list2.add(40.0);
        list2.add(20.0);

        System.out.println(Util.compareSumLists(list1,list2));

    }
}
