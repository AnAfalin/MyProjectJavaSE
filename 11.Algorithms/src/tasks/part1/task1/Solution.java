package tasks.part1.task1;

public class Solution {

    public static void main(String[] args) {
        String pattern = "l+j+k+";

        String text = "llk";
        String text2 = "lljjjjk";

        System.out.println(matches(pattern, text));
        System.out.println(matches(pattern, text2));

    }

    public static boolean matches(String pattern, String text) {
        if (!pattern.contains("+")) {
            return text.equals(pattern);
        }

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
