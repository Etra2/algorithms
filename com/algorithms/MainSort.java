package com.algorithms;

import com.algorithms.sorting.BubbleSort;
import com.algorithms.sorting.HeapSort;
import com.algorithms.sorting.MergeSort;
import com.algorithms.sorting.QuickSort;

import static com.algorithms.sorting.InsertionSort.insertionSort;
import static com.algorithms.sorting.QuickSortMonteCarlo.quickSortMC;

public class MainSort {
    public static void main(String[] args) {

        //BubbleSort 
        int[] array1 = {64, 34, 25, 12, 22, 11, 90};
        BubbleSort.bubbleSort(array1);

        System.out.println("BubbleSort - Tablica po sortowaniu:");
        for (int num : array1) {
            System.out.print(num + " ");
        }
        System.out.println();

        //ulepszone sortowanie Bąbelkowe
        BubbleSort.improvedBubbleSort(array1);
        System.out.println("improvedBubbleSort - - Tablica po sortowaniu:");
        for (int num : array1) {
            System.out.print(num + " ");
        }
        System.out.println();

        //InsertionSort
        int[] array = {23, 12, 45, 9, 67, 1, 34, 78, 56, 8, 90, 21, 3, 55, 77, 10, 43, 30, 66, 14};

        insertionSort(array);
        System.out.println("InsertionSort - Tablica po sortowaniu:");
        printArray(array);

        //MergeSort
        int[] arr = {12, 11, 13, 5, 6, 7, 8, 25, 12};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr);
        System.out.println("MergeSort - Tablica po sortowaniu:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        //QuickSort
        int[] array2 = {5, 3, 8, 4, 2, 7, 1, 6};
        QuickSort.quickSort(array2, 0, array2.length - 1);
        System.out.println("QuickSort - Tablica po sortowaniu:");
        for (int num : array2) {
            System.out.print(num + " ");
        }
        System.out.println();

        //QuickSort - MonteCarlo
        int[] array3 = {5, 3, 8, 4, 2, 7, 1, 6, 12, 14, 1, 0};
        quickSortMC(array3, 0, array3.length - 1);
        System.out.println("QuickSort - MonteCarlo - Tablica po sortowaniu:");
        for (int num : array3) {
            System.out.print(num + " ");
        }
        System.out.println();

        //QuickSort - LasVegas
        int[] array4 = {5, 3, 8, 4, 2, 7, 1, 6, 15, 16, 14, 0, 2};
        quickSortMC(array4, 0, array4.length - 1);
        System.out.println("QuickSort - LasVegas - Tablica po sortowaniu:");
        for (int num : array4) {
            System.out.print(num + " ");
        }
        System.out.println();

        //HeapSort
        int[] array5 = {12, 11, 13, 5, 6, 7};
        HeapSort.heapSort(array5);
        System.out.println("Posortowana tablica: ");
        for (int num : array5) {
            System.out.print(num + " ");
        }
    }


    public static void printArray(int[] array) {
        for (int value : array) { //iteruje po wszystkich elementach tablicy
            System.out.print(value + " "); //wyświetla każdy element oddzielony spacją
        }
        System.out.println(); //wyświetla nową linię po zakończeniu iteracji
    }
}

