package com.algorithms.search;

public class LinearSearch {
    //metoda wyszukiwania liniowego liczby całkowitej w tablicy
    public static int searchLinear(int array[], int x) {
        //petla for iterująca po tablicy
        for (int i = 0; i < array.length; i++) {
            //sprawdzenie czy znaleziono element szukany
            if (array[i] == x) {
                //jeśli znaleziony zwróć wartość
                return i;
            }
        }
        // w przeciwnym razie zwróć -1
        return -1;
    }
}

