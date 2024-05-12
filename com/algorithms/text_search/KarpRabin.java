package com.algorithms.text_search;

import java.util.ArrayList;
import java.util.List;

public class KarpRabin {
    private static final int BASE = 256; //bazowy system liczbowy
    private static final int PRIME = 101; //liczba pierwsza

    //metoda do znalezienia wzorca w tekście
    public static List<Integer> searchKR(String text, String pattern) {
        List<Integer> indexes = new ArrayList<>();
        int textLength = text.length();
        int patternLength = pattern.length();
        int patternHash = hash(pattern, patternLength); //hash wzorca
        int textHash = hash(text, patternLength); //hash początkowego fragmentu tekstu

        //porównanie hashy wzorca i początkowego fragmentu tekstu
        for (int i = 0; i <= textLength - patternLength; i++) {
            if (patternHash == textHash && checkEquals(text, pattern, i)) {
                indexes.add(i);
            }
            if (i < textLength - patternLength) {
                //aktualizacja hasha fragmentu tekstu
                textHash = updateHash(text, textHash, i, patternLength);
            }
        }
        return indexes;
    }

    //metoda do obliczenia hasha
    private static int hash(String str, int length) {
        int hash = 0;
        for (int i = 0; i < length; i++) {
            hash = (hash * BASE + str.charAt(i)) % PRIME;
        }
        return hash;
    }

    //metoda do aktualizacji hasha przy przesunięciu okienka
    private static int updateHash(String str, int hash, int index, int length) {
        hash = (hash - str.charAt(index) * pow(BASE, length - 1)) % PRIME;
        hash = (hash * BASE + str.charAt(index + length)) % PRIME;
        if (hash < 0) {
            hash += PRIME;
        }
        return hash;
    }

    //metoda do sprawdzenia czy wzorzec równa się fragmnetowi tekstu
    private static boolean checkEquals(String text, String pattern, int index) {
        for (int i = 0; i < pattern.length(); i++) {
            if (text.charAt(index + i) != pattern.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    // Metoda do obliczenia potęgi
    private static int pow(int x, int y) {
        int result = 1;
        for (int i = 0; i < y; i++) {
            result = (result * x) % PRIME;
        }
        return result;
    }
}
