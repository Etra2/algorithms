package com.algorithms.arithmetic;

public class EuclidsAlgorithm {

    //metoda do obliczania największego wspólnego dzielnika (NWD) dwóch liczb; GCD - greatest common divisor
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

}
