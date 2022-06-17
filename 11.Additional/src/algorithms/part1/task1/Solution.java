package algorithms.part1.task1;

public class Solution {

    public static void main(String[] args) {
        String pattern = "l+j+";

        String text = "jjj";

        System.out.println(matches(pattern, text));

    }

    public static boolean matches(String pattern, String text){
        if(!pattern.contains("+")){
            return text.equals(pattern);
        }

        boolean isContains = false;
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) != '+'){
                if(text.contains(Character.toString(pattern.charAt(i)))){
                    isContains = true;
                }
                if(isContains){
                    return true;
                }
            }
        }
        return false;
    }

}
