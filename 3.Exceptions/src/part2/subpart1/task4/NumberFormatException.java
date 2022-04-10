package part2.subpart1.task4;

import java.util.Scanner;

public class NumberFormatException extends RuntimeException {
    public NumberFormatException(String message) {
        super(message);
    }
}



class Main{
    public static void main(String[] args)  {
        try {
            getCharacter("String", 45);
        }catch (RuntimeException ex){
            Throwable cause = ex.getCause();
            System.out.println(cause.getMessage());
        }

    }

    public static char getCharacter(String str, int index) {
        if(index < 0 || index > str.length()-1) {
            throw new NumberFormatException("Индекс за пределами длины строки");
        }
        return str.charAt(index);
    }

}
