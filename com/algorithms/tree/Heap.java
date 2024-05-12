package com.algorithms.tree;

import java.util.Arrays;

public class Heap {
    private int[] heapArray;
    private int heapSize;

    public Heap(int maxSize) {
        heapArray = new int[maxSize];
        heapSize = 0;
    }

    //wstawianie elementu do kopca
    public void insert(int value) {
        if (heapSize == heapArray.length) {
            System.out.println("Kopiec jest pełny. Nie można wstawić więcej elementów.");
            return;
        }
        heapArray[heapSize] = value;
        heapSize++;
        heapifyUp(heapSize - 1);
    }

    //usuwanie korzenia
    public int removeRoot() {
        if (isEmpty()) {
            System.out.println("kopiec jest pusty.");
            return -1;
        }
        int root = heapArray[0];
        heapArray[0] = heapArray[heapSize - 1];
        heapSize--;
        heapifyDown(0);
        return root;
    }

    //zmiana priorytetu elemntu o indeksie
    public void changePriority(int index, int newValue) {
        if (index < 0 || index >= heapSize) {
            System.out.println("Nieprawidłowy indeks.");
            return;
        }
        int oldValue = heapArray[index];
        heapArray[index] = newValue;
        if (newValue > oldValue) {
            heapifyUp(index);
        } else {
            heapifyDown(index);
        }
    }

    //konstruowanie kopca z tablicy
    public void buildHeap(int[] array) {
        heapArray = Arrays.copyOf(array, array.length);
        heapSize = array.length;
        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            heapifyDown(i);
        }
    }

    //sortowanie przez kopcowanie
    public void heapSort() {
        int[] sortedArray = new int[heapSize];
        int originalSize = heapSize;
        for (int i = 0; i < originalSize; i++) {
            sortedArray[i] = removeRoot();
        }
        heapArray = sortedArray;
        heapSize = originalSize;
    }

    //wyrównanie w górę
    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;
        while (index > 0 && heapArray[index] > heapArray[parentIndex]) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    //wyrównywanie w dół
    private void heapifyDown(int index) {
        int maxChild;
        while (index < heapSize / 2){
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            if (rightChild < heapSize && heapArray[rightChild] > heapArray[leftChild]) {
                maxChild = rightChild;
            } else {
                maxChild = leftChild;
            }
            if (heapArray[index] >= heapArray[maxChild]) {
                break;
            }
            swap(index, maxChild);
            index = maxChild;
        }
    }

    //sprawdzanie, czy kopiec jest pusty
    public boolean isEmpty(){
        return  heapSize ==0;
    }

    //zamiana miejscami elementów w tablicy
    private void swap(int i, int j) {
        int temp = heapArray[i];
        heapArray[i] = heapArray[j];
        heapArray[j] = temp;
    }

    //metoda do wyświetlania kopca (do testów)
    public void displayHeap() {
        System.out.print("Kopiec: ");
        for (int i = 0; i < heapSize; i++) {
            System.out.print(heapArray[i] + " ");
        }
        System.out.println();
    }
}
