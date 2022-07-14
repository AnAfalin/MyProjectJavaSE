package part2.task4;

import java.time.Month;

public class Solution {
    public static void main(String[] args) {
        Month month = Month.JULY;
        String strMonth = month.toString();

        int day = Month.valueOf(strMonth).maxLength();
        System.out.println("In month " + strMonth + " " + day + " days");
    }
}
