package com.algorithms;

import com.algorithms.arithmetic.EuclidsAlgorithm;
import com.algorithms.arithmetic.FactorialRecursion;
import com.algorithms.arithmetic.Fibonacci;

import java.math.BigInteger;

import static com.algorithms.arithmetic.FactorialRecursion.calculateFactorialBI;

import static com.algorithms.arithmetic.SieveOfEratosthenes.findPrimes;

public class MainArithmetic {

    public static void main(String[] args) {

        //silnia rekurencja
        int n = 12;
        int result1 = FactorialRecursion.calculateFactorial(n);
        System.out.println("Silnia z " + n + " to: " + result1);

        //silnia rekurencja opakowana
        BigInteger m = new BigInteger("20"); //przykładowa wartość dla której obliczamy silnię
        BigInteger factorial = calculateFactorialBI(m);
        System.out.println("Silnia z " + m + " wynosi: " + factorial);

        //NWD - Euklides
        int num1 = 84;
        int num2 = 126;
        int result2 = EuclidsAlgorithm.gcd(num1, num2);
        System.out.println("Największy wspólny dzielnik (" + num1 + ", " + num2 + ") = " + result2);

        //Sito Eratostenesa
        int e = 120;
        findPrimes(e);

        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Przed sortowaniem:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        //Fibonacci
        int f = 10; //przykładowa liczba w ciągu Fibonacciego do wygenerowania

        //sprawdzenie metody iteracyjnej
        System.out.println("Ciąg Fibonacciego (iteracyjnie):");
        for (int i = 0; i < f; i++) {
            System.out.print(Fibonacci.fibonacciIterative(i) + " ");
        }
        System.out.println();

        //sprawdzenie metody rekurencyjnej
        System.out.println("Ciąg Fibonacciego (rekurencyjnie):");
        for (int i = 0; i < f; i++) {
            System.out.print(Fibonacci.fibonacciRecursive(i) + " ");
        }
        System.out.println();

        //sprawdzenie metody dynamicznej
        System.out.println("Ciąg Fibonacciego (dynamicznie):");
        for (int i = 0; i < f; i++) {
            System.out.print(Fibonacci.fibonacciDynamic(i) + " ");
        }
        System.out.println();
    }
}
