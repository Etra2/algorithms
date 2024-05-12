package com.algorithms.arithmetic;

public class SieveOfEratosthenes {
        public static void findPrimes(int n) {
            boolean[] primes = new boolean[n + 1]; //tablica przechowująca informacje o liczbach pierwszych

            //inicjalizacja tablicy wartościami domyślnymi (true = liczba pierwsza)
            for (int i = 2; i <= n; i++) {
                primes[i] = true;
            }

            //algorytm Sita Eratostenesa
            for (int p = 2; p * p <= n; p++) {
                //jeśli p jest liczbą pierwszą, oznaczam wszystkie jej wielokrotności jako liczby złożone
                if (primes[p]) {
                    for (int i = p * p; i <= n; i += p) {
                        primes[i] = false;
                    }
                }
            }

            //wyświetlenie liczb pierwszych
            System.out.println("Liczby pierwsze od 2 do " + n + ":");
            for (int i = 2; i <= n; i++) {
                if (primes[i]) {
                    System.out.print(i + " ");
                }
            }
        }
}
