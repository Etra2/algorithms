package com.algorithms.search;

public class LSWithSentinel {
        //wyszukiwanie liniowe z wartownikiem w tablicy liczb całkowitych
        public static int linearSearchSentinel(int tab[], int x) {
            //zapisujemy oryginalną wartość ostatniego elementu
            int lastElement = tab[tab.length - 1];
            // Dodajemy wartownika na końcu tablicy
            tab[tab.length - 1] = x;

            //wyszukiwanie liniowe z wartownikiem
            int i = 0;
            while (tab[i] != x) {
                i++;
            }

            //przywracamy oryginalną wartość na końcu tablicy
            tab[tab.length - 1] = lastElement;

            //jeżeli znaleziono wartość, zwróć wartość jeśli nie zwróć -1
            if (i < tab.length - 1 || tab[tab.length - 1] == x) {
                return i;
            } else {
                return -1;
            }
        }
}
