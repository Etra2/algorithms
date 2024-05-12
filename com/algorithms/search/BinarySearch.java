package com.algorithms.search;

public class BinarySearch {
    //metoda wyszukiwania binarnego liczby całkowitej w tablicy (!pamiętaj elementy tablicy muszą być posortowane)
    public static int binarySearch(int array[], int x) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            //sprawdź, czy szukana znajduje się w połowie
            if (array[mid] == x) {
                return mid;
            }
            //jeśli szukana jest mniejsza, ignoruj prawą połowę
            if (array[mid] < x) {
                left = mid + 1;
            }
            //jeśli szukana jest większa, ignoruj lewą połowę
            else {
                right = mid - 1;
            }
        }
        //jeśli szukana nie została znaleziona, zwróć -1
        return -1;
    }
}

