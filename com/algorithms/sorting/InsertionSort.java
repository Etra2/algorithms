package com.algorithms.sorting;

public class InsertionSort {
        public static void insertionSort(int[] array) {
            //zapisuje długość tablicy, aby uniknąć wielokrotnego wywoływania array.length w pętli
            int n = array.length;
            //pętla zaczyna od drugiego elementu tablicy, ponieważ zakładamy, że pierwszy element jest już posortowany
            for (int i = 1; i < n; i++) {
                //przechowuje aktualnie analizowany element tablicy
                int key = array[i];
                //ustawiam wskaźnik na poprzedni element od aktualnego (czyli i-1)
                int j = i - 1;

                //przesuwam elementów większych od klucza
                while (j >= 0 && array[j] > key) { //dopóki istnieją elementy, większe od klucza i dopóki nie doszliśmy do początku tablicy
                    array[j + 1] = array[j]; //przesuwam większe elementy o jedną pozycję w prawo
                    j--; //przesuwam wskaźnik w lewo
                }
                array[j + 1] = key; //wstawiam klucz na właściwą pozycję
            }
        }
}
