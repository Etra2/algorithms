package com.algorithms;

import java.util.List;


import com.algorithms.text_search.BoyerMoore;
import com.algorithms.text_search.KarpRabin;
import static com.algorithms.text_search.KnuthMorrisPratt.searchKMP;
import static com.algorithms.text_search.Naive.searchText;


public class MainTextSearch {
    public static void main(String[] args) {
        //tekst i wzorzec
        String text = "Język Java to obiektowy język programowania, który cechuje się bezpieczeństwem typów, dzięki czemu unika się wielu błędów wynikających z nieprawidłowego użycia zmiennych. Jego platforma, Java Virtual Machine (JVM), umożliwia przenośność kodu pomiędzy różnymi systemami operacyjnymi, co sprawia, że Java jest popularnym wyborem dla aplikacji o dużym zasięgu. Dodatkowo, Java jest silnie rozbudowanym językiem, oferującym bogatą bibliotekę standardową, co ułatwia tworzenie złożonych programów.";
        String pattern = "Java";

        //algorytm Naive
        System.out.println("W algorytmie naiwnym numery indeksów, gdzie znaleziono wzorzec to: ");
        searchText(text, pattern);

        //KMP
        System.out.println("W algorytmie Knuth Morris Pratt numery indeksów, gdzie znaleziono wzorzec to: ");
        List<Integer> indices = searchKMP(text, pattern);
        for (int index : indices) {
            System.out.println(index);
        }

        //KR
        System.out.println("W algorytmie Karp Rabin numery indeksów, gdzie znaleziono wzorzec to: ");
        List<Integer> indexes = KarpRabin.searchKR(text, pattern);
        for (int i = 0; i < indexes.size(); i++) {
            System.out.println(indexes.get(i));
        }

        //BM
        System.out.println("W algorytmie Boyer Moore numery indeksów, gdzie znaleziono wzorzec to: ");
        BoyerMoore bm = new BoyerMoore(pattern);
        List<Integer> offsets = bm.searchBM(text);

        if (!offsets.isEmpty()) {
            for (int offset : offsets) {
                System.out.println(offset);
            }
        }
    }
}
