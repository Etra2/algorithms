package com.algorithms.text_search;

import java.util.ArrayList;
import java.util.List;

public class KnuthMorrisPratt {

    //metoda do tworzenia tablicy prefiksowej dla wzorca
    private static int[] computePrefixFunction(String pattern) {
        int[] prefix = new int[pattern.length()]; //inicjalizacja tablicy prefiksowej
        int k = 0; //inicjalizacja wskaźnika do aktualnego prefiksu

        //pętla iterująca przez wzorzec (pozycje indeksów)
        for (int q = 1; q < pattern.length(); q++) {
            //dopóki aktualny prefiks nie jest zerowy i znaki na pozycjach k i q nie są takie same
            while (k > 0 && pattern.charAt(k) != pattern.charAt(q)) {
                //przesuwaj wskaźnik prefiksu wstecz na podstawie tablicy prefiksowej
                k = prefix[k - 1];
            }
            //jeśli znaki na pozycjach k i q są takie same
            if (pattern.charAt(k) == pattern.charAt(q)) {
                //zwiększ wartość wskaźnika prefiksu
                k++;
            }
            //przypisz obliczoną wartość prefiksu na pozycji q w tablicy prefiksowej
            prefix[q] = k;
        }
        //zwróć tablicę prefiksową
        return prefix;
    }

    // Metoda wyszukująca wzorzec w tekście i zwracająca listę indeksów, na których wzorzec został znaleziony
    public static List<Integer> searchKMP(String text, String pattern) {
        List<Integer> indices = new ArrayList<>(); // Inicjalizacja listy indeksów
        int n = text.length(); // Długość tekstu
        int m = pattern.length(); // Długość wzorca
        int[] prefix = computePrefixFunction(pattern); // Obliczenie tablicy prefiksowej
        int q = 0; // Inicjalizacja licznika dopasowania wzorca

        // Pętla iterująca przez tekst (pozycje indeksów)
        for (int i = 0; i < n; i++) {
            // Dopóki licznik dopasowania nie jest zerowy i znaki na pozycjach q i i nie są takie same
            while (q > 0 && pattern.charAt(q) != text.charAt(i)) {
                // Przesuwaj licznik dopasowania wstecz na podstawie tablicy prefiksowej
                q = prefix[q - 1];
            }
            // Jeśli znaki na pozycjach q i i są takie same
            if (pattern.charAt(q) == text.charAt(i)) {
                // Zwiększ wartość licznika dopasowania
                q++;
            }
            // Jeśli licznik dopasowania osiągnie długość wzorca, to znaleziono wzorzec
            if (q == m) {
                // Dodaj indeks znalezionego wzorca do listy indeksów
                indices.add(i - m + 1);
                // Przesuń licznik dopasowania wstecz na podstawie tablicy prefiksowej
                q = prefix[q - 1];
            }
        }
        // Zwróć listę indeksów, na których znaleziono wzorzec
        return indices;
    }
}
