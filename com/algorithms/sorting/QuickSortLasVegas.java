package com.algorithms.sorting;
import java.util.Random;

public class QuickSortLasVegas {
    public static void quicksortLV(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = lasVegasPartition(array, low, high);
            quicksortLV(array, low, pivotIndex - 1);
            quicksortLV(array, pivotIndex + 1, high);
        }
    }

    public static int lasVegasPartition(int[] array, int low, int high) {
        Random rand = new Random();
        int randomIndex;
        int pivot = array[high];
        do {
            randomIndex = rand.nextInt(high - low + 1) + low;
        } while (array[randomIndex] != pivot); //dopóki nie znajdziemy pivota, który występuje w tablicy
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

