package part2.subpart1.task4;


public class Solution{
    public static void main(String[] args)  {
        try {
            String element = getCharacter(new String[] {"1", "2", "3a"}, "2a");
        }
        catch (RuntimeException ex){
            // ex.printStackTrace();

            Throwable throwable = ex.getCause();
            throwable.printStackTrace();
        }
    }

    public static String getCharacter(String[] array, String index) {
        int idx = 0;
        try{
            idx = parseIntFromString(index);
        }
        catch (NumberFormatException ex){
            MyArrayIndexOutOfBoundsException exIndex = new MyArrayIndexOutOfBoundsException("Недопустимый индекс");
            exIndex.initCause(ex);
            throw exIndex;
        }

        return array[idx];
    }

    public static int parseIntFromString(String element){
        return Integer.parseInt(element);
    }
}


class MyArrayIndexOutOfBoundsException extends RuntimeException{
    public MyArrayIndexOutOfBoundsException(String message) {
        super(message);
    }

    public MyArrayIndexOutOfBoundsException(String message, Throwable cause) {
        super(message, cause);
    }
}