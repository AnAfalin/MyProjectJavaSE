package part4.task2;

import java.util.Optional;

public class Solution {
    public static void main(String[] args) {
        String str = null;

        //не работает
        //Params: value – the value to describe, which must be non-nulReturns:
        //Returns: an Optional with the value present
        //Throws: NullPointerException – if value is null
        Optional<String> optionalOf = Optional.of(str);

        //работает
        //Params: value – the possibly-null value to describe
        //Returns: an Optional with a present value if the specified value is non-null, otherwise an empty Optional
        Optional<String> optionalOfNullable = Optional.ofNullable(str);


    }

}
