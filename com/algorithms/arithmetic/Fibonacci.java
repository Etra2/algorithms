package com.algorithms.arithmetic;

public class Fibonacci {
    //metoda generująca ciąg Fibonacciego iteracyjnie
    public static int fibonacciIterative(int n) {
        if (n <= 1)
            return n;
        int fibPrev = 0;
        int fibCurr = 1;
        for (int i = 2; i <= n; i++) {
            int fibNext = fibPrev + fibCurr;
            fibPrev = fibCurr;
            fibCurr = fibNext;
        }
        return fibCurr;
    }

    //metoda generująca ciąg Fibonacciego rekurencyjnie
    public static int fibonacciRecursive(int n) {
        if (n <= 1)
            return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    //metoda generująca ciąg Fibonacciego z użyciem programowania dynamicznego
    public static int fibonacciDynamic(int n) {
        if (n <= 1)
            return n;
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }
}



