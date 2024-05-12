package com.algorithms.text_search;

public class Naive {
    //metoda wyszukująca wzorzec w tekście
    public static void searchText(String text, String pattern) {
        int m = pattern.length();
        int n = text.length();

        //iteruj po wszystkich możliwych początkach podciągów tekstu,
        //które mają długość równą długości wzorca
        for (int i = 0; i <= n - m; i++) {
            int j;

            //sprawdź znaki w podciągu tekstu i wzorca
            for (j = 0; j < m; j++) {
                //normalizuj litery i ignoruj wielkość liter
                if (Character.toLowerCase(text.charAt(i + j)) != Character.toLowerCase(pattern.charAt(j))) {
                    //jeśli znaleziono różnicę, przerwij wewnętrzną pętlę
                    // i sprawdź kolejny podciąg tekstu
                    break;
                }
            }
            //jeśli j jest równe długości wzorca, oznacza to, że wszystkie
            // znaki wzorca pasują do podciągu tekstu od pozycji 'i',
            // więc wypisz indeks, na którym został znaleziony wzorzec
            if (j == m) {
                System.out.println(i);
            }
        }
    }
}
