package com.algorithms.graph;

import java.util.*;

//klasa reprezentująca graf
public class Kruskal {
    int V, E; //liczba wierzchołków i krawędzi
    EdgeBFS[] edges; //tablica krawędzi

    //konstruktor grafu
    public Kruskal(int v, int e) {
        V = v;
        E = e;
        edges = new EdgeBFS[E]; //inicjalizujemy tablicę krawędzi
        for (int i = 0; i < e; ++i)
            edges[i] = new EdgeBFS(0, 0, 0); //tworzymy nowe obiekty krawędzi.
    }

    public EdgeBFS[] getEdges() {
        return edges;
    }

    //metoda do znajdowania korzenia zbioru
    int find(int[] parent, int i) {
        if (parent[i] == i)
            return i;
        return find(parent, parent[i]);
    }

    //metoda łącząca dwa zbiory
    void union(int[] parent, int[] rank, int x, int y) {
        int xRoot = find(parent, x);
        int yRoot = find(parent, y);

        if (rank[xRoot] < rank[yRoot])
            parent[xRoot] = yRoot;
        else if (rank[yRoot] < rank[xRoot])
            parent[yRoot] = xRoot;
        else {
            parent[yRoot] = xRoot;
            rank[xRoot]++;
        }
    }

    //implementacja algorytmu Kruskala
    public void KruskalMST() {
        EdgeBFS[] result = new EdgeBFS[V]; //tablica przechowująca krawędzie MST
        int e = 0; //licznik krawędzi MST.
        int i = 0;

        //inicjalizacja tablic pomocniczych
        for (i = 0; i < V; ++i)
            result[i] = new EdgeBFS(0, 0, 0);

        // Sortujemy krawędzie według wag
        Arrays.sort(edges);

        int[] parent = new int[V]; // Tablica rodziców dla zbiorów
        int[] rank = new int[V]; // Tablica rank dla zbiorów

        // Inicjalizacja zbiorów
        for (int v = 0; v < V; ++v) {
            parent[v] = v;
            rank[v] = 0;
        }

        i = 0;

        // Główna pętla algorytmu Kruskala
        while (e < V - 1) {
            EdgeBFS next_edge = edges[i++];

            int x = find(parent, next_edge.source);
            int y = find(parent, next_edge.destination);

            // Sprawdzamy, czy dodanie krawędzi next_edge nie spowoduje cyklu
            if (x != y) {
                result[e++] = next_edge;
                union(parent, rank, x, y);
            }
        }

        // Wyświetlamy krawędzie MST
        System.out.println("Poniżej znajdują się krawędzie skonstruowanego MST");
        for (i = 0; i < e; ++i)
            System.out.println(result[i].source + " -- " +
                    result[i].destination +
                    " == " + result[i].weight);
    }
}