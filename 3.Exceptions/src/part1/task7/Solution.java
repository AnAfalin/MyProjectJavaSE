package part1.task7;

public class Solution {

    public static void main(String[] args) throws Exception {
        test();
    }

    public static int test(){
        try {
            return generateLuckyNumber();
        }
        catch (RuntimeException ex){
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    public static int generateLuckyNumber() {
        int luckyNumber = (int) (Math.random() * 100);
        if (luckyNumber == 13) {
            throw new RuntimeException("не повезло");
        }
        return luckyNumber;
    }
}



