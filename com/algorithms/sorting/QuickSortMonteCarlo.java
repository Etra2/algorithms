package com.algorithms.sorting;

import java.util.Random;

public class QuickSortMonteCarlo {

    public static void quickSortMC(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = monteCarloPartition(array, low, high);
            quickSortMC(array, low, pivotIndex - 1);
            quickSortMC(array, pivotIndex + 1, high);
        }
    }

    public static int monteCarloPartition(int[] array, int low, int high) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(high - low + 1) + low; //losowy indeks w przedziale [low, high]
        int temp = array[high];
        array[high] = array[randomIndex];
        array[randomIndex] = temp;
        return partition(array, low, high);
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}

