package algorithms.part1.task1;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        String pattern = "l+j+k+";

        String text = "llk";

        System.out.println(matches(pattern, text));

    }

    public static boolean matches(String pattern, String text) {
        if (!pattern.contains("+")) {
            return text.equals(pattern);
        }

        boolean isContains = false;
        String[] s = pattern.split("[+]");

        StringBuilder stringBuilder = new StringBuilder(text);
        for (int i = s.length - 1; i > 0 ; i--) {
            if(Character.toString(stringBuilder.charAt(stringBuilder.length() - 1)).equals(s[i])){
                stringBuilder.delete(stringBuilder.indexOf(s[i]), stringBuilder.length());
            }else {
                return false;
            }
        }
        return true;
    }

}
