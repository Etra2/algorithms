package com.algorithms.sorting;

public class MergeSort {

    //metoda sortująca tablicę za pomocą algorytmu MergeSort
    public void sort(int[] arr) {
        //sprawdzenie czy tablica jest pusta lub null
        if (arr == null || arr.length == 0) {
            return; // Jeśli tak, to zakończ działanie
        }
        //wywołanie metody mergeSort dla całej tablicy
        mergeSort(arr, 0, arr.length - 1);
    }

    //metoda pomocnicza dla sortowania MergeSort
    private void mergeSort(int[] arr, int left, int right) {
        //warunek kończący rekurencję, gdy tylko jeden element
        if (left < right) {
            //obliczenie środka tablicy
            int mid = (left + right) / 2;
            //wywołanie mergeSort dla lewej części tablicy
            mergeSort(arr, left, mid);
            //wywołanie mergeSort dla prawej części tablicy
            mergeSort(arr, mid + 1, right);
            //scalanie dwóch posortowanych części tablicy
            merge(arr, left, mid, right);
        }
    }

    // Metoda scalająca dwie posortowane części tablicy
    private void merge(int[] arr, int left, int mid, int right) {
        // Obliczenie długości obu części
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Utworzenie tablic pomocniczych dla lewej i prawej części
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Przekopiowanie elementów do tablic pomocniczych
        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        // Scalanie obu części tablicy w jedną posortowaną
        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Dodanie pozostałych elementów z tablicy L
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Dodanie pozostałych elementów z tablicy R
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
