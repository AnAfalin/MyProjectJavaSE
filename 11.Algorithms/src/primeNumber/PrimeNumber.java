package primeNumber;

/*
Алгоритм поиска простых числе
Проесто число - число, которое делится на 1 и на само себя
// 2, 3, 5, 7, 9, 13, 17, 19, 21, 23 ...
 */

import java.util.ArrayList;
import java.util.List;

public class PrimeNumber {
    public static void main(String[] args) {
        List<Integer> list = getPrimes(100);
        System.out.println(list);
    }

    public static List<Integer> getPrimes(int count){
        List<Integer> listPrime = new ArrayList<>();
        if (count > 0){
            listPrime.add(2);
        }
        for (int n = 3; n < count; n++) {
            if (isPrime(n, listPrime)){
                listPrime.add(n);
            }
        }
        return listPrime;
    }

    private static boolean isPrime(int n, List<Integer> listPrime) {
        for (int number : listPrime) {
            if (number * number > n) {
                return true;
            }
            if (n % number == 0) {
                return false;
            }
        }
        return true;
    }
}
