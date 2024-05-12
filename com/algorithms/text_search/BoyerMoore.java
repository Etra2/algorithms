package com.algorithms.text_search;

import java.util.*;

public class BoyerMoore {

        private final String pattern;  //szukany wzorzec
        private final Map<Character, Integer> right; //mapa przesunięć prawych

        public BoyerMoore(String pattern) {
            this.pattern = pattern;
            this.right = new HashMap<>();

            for (int i = 0; i < pattern.length(); i++) {
                right.put(pattern.charAt(i), i);
            }
        }

        //metoda do wyszukiwania wzorca w tekście
        public List<Integer> searchBM(String txt) {
            List<Integer> offsets = new ArrayList<>();

            int M = pattern.length();
            int N = txt.length();
            int skip;

            for (int i = 0; i <= N - M; i += skip) {
                skip = 0;
                for (int j = M - 1; j >= 0; j--) {
                    if (pattern.charAt(j) != txt.charAt(i + j)) {
                        skip = Math.max(1, j - right.getOrDefault(txt.charAt(i + j), -1));
                        break;
                    }
                }
                if (skip == 0) {
                    offsets.add(i); //wzorzec znaleziony
                    skip = 1;
                }
            }
            return offsets;
        }
}
