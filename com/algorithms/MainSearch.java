package com.algorithms;

import com.algorithms.arithmetic.EuclidsAlgorithm;
import com.algorithms.arithmetic.FactorialRecursion;
import com.algorithms.search.BinarySearch;
import com.algorithms.search.LSWithSentinel;
import com.algorithms.search.LinearSearch;

import java.math.BigInteger;

import static com.algorithms.arithmetic.FactorialRecursion.calculateFactorialBI;
import static com.algorithms.arithmetic.SieveOfEratosthenes.findPrimes;


public class MainSearch {
    public static void main(String[] args) {

        //tablica testowa
        int arrayTest[] = {1,2,3,4,5,6,7,8,9,0,10,12,13,14,15};
        int a = 5;
        //sprawdzenie wyszukiwanie liniowe
        LinearSearch search = new LinearSearch();
        int showResult = LinearSearch.searchLinear(arrayTest, a);

        if (showResult != -1) {
            System.out.println("Element znajduje się na indeksie " + showResult + ".");
        } else {
            System.out.println("Nie znaleziono wartości " + a + " w tablicy.");
        }

        //sprawdzenie wyszukiwanie liniowe z wartownikiem
        LSWithSentinel search1 = new LSWithSentinel();
        int orFound = search1.linearSearchSentinel(arrayTest,a);

        if (orFound != -1) {
            System.out.println("Element znajduje się na indeksie " + orFound + ".");
        } else {
            System.out.println("Nie znaleziono wartości " + a + " w tablicy.");
        }

        //sprawdzenie wyszukiwanie binarne
        BinarySearch search2 = new BinarySearch();
        int result = search2.binarySearch(arrayTest, a);

        if (result != -1) {
            System.out.println("Element znajduje się na indeksie " + result + ".");
        } else {
            System.out.println("Nie znaleziono wartości " + a + " w tablicy.");
        }

    }


}

