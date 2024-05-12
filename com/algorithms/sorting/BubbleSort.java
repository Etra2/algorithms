package com.algorithms.sorting;

public class BubbleSort {

    //metoda do sortowania bąbelkowego
    public static void bubbleSort(int[] array) {
        //pobierz długość tablicy
        int n = array.length;
        //pętla zewnętrzna: przechodzi przez wszystkie elementy tablicy, poza ostatnim
        for (int i = 0; i < n - 1; i++) {
            //pętla wewnętrzna: porównuje i zamienia sąsiednie elementy
            for (int j = 0; j < n - i - 1; j++) {
                //sprawdź, czy bieżący element jest większy od następnego
                if (array[j] > array[j + 1]) {
                    //jeśli tak, zamień miejscami elementy
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    //ulepszone sortowanie bąbelkowe
    public static void improvedBubbleSort(int[] array) {
        int n = array.length;
        boolean swapped; //zmienna wskazująca, czy dokonano zamiany w danym przejściu
        for (int i = 0; i < n - 1; i++) {
            swapped = false; //na początku zakładamy, że nie dokonano żadnej zamiany
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    //jeśli bieżący element jest większy od następnego, dokonaj zamiany
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true; //ustaw flagę na true, aby oznaczyć, że dokonano zamiany
                }
            }
            //jeśli nie dokonano żadnej zamiany w danym przejściu, zakończ sortowanie
            if (!swapped) {
                break;
            }
        }
    }

}