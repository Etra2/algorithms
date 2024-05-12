package com.algorithms.sorting;

public class HeapSort {
    //logika sortowania
    public static void heapSort (int[] array) {
        int n = array.length;

        //buduje kopiec
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        //sortujemy przez wymianę i naprawę kopca
        for (int i = n - 1; i >= 0; i--) {
            //zamieniamy korzeń z ostatnim elementem
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            //naprawiam kopiec na tablicy o rozmiarze zmniejszonym o 1
            heapify(array, i, 0);
        }
    }

    //budowanie kopca
    private static void heapify (int[] array, int n, int i) {
        int largestRoot = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        //sprawdzam czy lewe dziecko jest większe od korzenia
        if (leftChild < n && array[leftChild] > array[largestRoot]) {
            largestRoot = leftChild;
        }

        //sprawdzam czy prawe dziecko jest wieksze od największego dotychczas elementu
        if (rightChild < n && array[rightChild] > array[largestRoot]) {
            largestRoot = rightChild;
        }

        //jeżeli największy element nie jest korzeniem zamieniamy korzeń z najwiekszym elementem
        if (largestRoot != i) {
            int temp = array[i];
            array[i] = array[largestRoot];
            array[largestRoot] = temp;
            //rekurencyjna naprawa kopca na poddrzewie
            heapify(array, n, largestRoot);
        }
    }

}
