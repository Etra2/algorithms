package com.algorithms.graph;

//klasa reprezentująca algorytm Floyda-Warshalla
public class FloydWarshall {
    //stała reprezentująca nieskończoność INF - infinity
    public static final int INF = 99999;

    //metoda implementująca algorytmu Floyd-Warshall
    public static void floydWarshall(int[][] graph, int V) {
        int[][] dist = new int[V][V];
        int i, j, k;

        //inicjalizacja macierzy odległości tak, żeby zawierała wagi krawędzi
        for (i = 0; i < V; i++) {
            for (j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        //iteracyjne obliczanie najkrótszych ścieżek między każdą parą wierzchołków
        for (k = 0; k < V; k++) {
            for (i = 0; i < V; i++) {
                for (j = 0; j < V; j++) {
                    //aktualizacja odległości, jeśli istnieje krótsza ścieżka przez wierzchołek k
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        //wyświetlenie macierzy odległości, z najkrótszymi ścieżkami między parami wierzchołków
        printSolution(dist, V);
    }

    //metoda do wyświetlania macierzy odległości
    public static void printSolution(int[][] dist, int V) {
        System.out.println("Najkrótsze odległości miedzy parami wierzchołków:");
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + "  ");
                }
            }
            System.out.println();
        }
    }

}
