package com.algorithms.arithmetic;

import java.math.BigInteger;

public class FactorialRecursion {
    //kod dla int zakres wyniku do 2147483647, czyli n = 12!
    public static int calculateFactorial(int n) {
        if (n == 0) {
            return 1; //Silnia z 0 wynosi 1
        } else {
            return n * calculateFactorial(n - 1); //rekurencyjne wywołanie funkcji obliczającej silnię
        }
    }
    //kod dla BigInteger zakres b. duzych liczb
    public static BigInteger calculateFactorialBI(BigInteger n) {
        if (n.equals(BigInteger.ZERO)) {
            return BigInteger.ONE; //Silnia z 0 wynosi 1
        } else {
            return n.multiply(calculateFactorialBI(n.subtract(BigInteger.ONE))); // Rekurencyjne wywołanie funkcji obliczającej silnię
        }
    }
}
