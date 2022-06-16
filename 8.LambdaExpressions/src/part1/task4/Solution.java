package part1.task4;

import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
//        Comparator<String> comparator = new Comparator<String>() {
//            @Override
//            public int compare(String str1, String str2) {
//                if(str1.length() > str2.length()){
//                    return 1;
//                }else if(str1.length() < str2.length()){
//                    return -1;
//                }else {
//                    return 0;
//                }
//            }
//        };

//        Comparator<String> comparator = new Comparator<String>() {
//            @Override
//            public int compare(String str1, String str2) {
//                return Integer.compare(str1.length(), str2.length());
//            }
//        };

        Comparator<String> comparator = Comparator.comparingInt(String::length);
    }
}
