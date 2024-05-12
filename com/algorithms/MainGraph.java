package com.algorithms;

import com.algorithms.graph.*;
import com.algorithms.graph.NodeDijkstra;
import java.util.*;

import static com.algorithms.graph.FloydWarshall.INF;

public class MainGraph {
    public static void main(String[] args) {

        //tworzenie grafu - 5 wierzchołków
        GraphBFS graphTest = new GraphBFS(5);

        //dodawanie krawędzi grafu
        graphTest.addEdge(0, 1);
        graphTest.addEdge(0, 3);
        graphTest.addEdge(1, 0);
        graphTest.addEdge(1, 2);
        graphTest.addEdge(1, 3);
        graphTest.addEdge(2, 1);
        graphTest.addEdge(2, 4);
        graphTest.addEdge(3, 0);
        graphTest.addEdge(3, 1);
        graphTest.addEdge(4, 2);

        //GraphBFS
        System.out.println("Przechodzenie BFS: ");
        //zaczynamy od 2
        graphTest.BFS(2);

        GraphDFS graphTest1 = new GraphDFS(5);

        graphTest1.addEdge(0, 1);
        graphTest1.addEdge(0, 3);
        graphTest1.addEdge(1, 0);
        graphTest1.addEdge(1, 2);
        graphTest1.addEdge(1, 3);
        graphTest1.addEdge(2, 1);
        graphTest1.addEdge(2, 4);
        graphTest1.addEdge(3, 0);
        graphTest1.addEdge(3, 1);
        graphTest1.addEdge(4, 2);

        //GraphDFS
        System.out.println("Przechodzenie DFS: ");
        //zaczynamy od 2
        graphTest1.DFS(2);

        //Kruskal
        int V = 4;  //liczba wierzchołków w grafie.
        int E = 5;  //liczba krawędzi w grafie.
        Kruskal kruskal = new Kruskal(V, E); //tworzymy obiekt grafu.

        //dodajemy krawędzie do grafu.
        kruskal.getEdges()[0] = new EdgeBFS(0, 1, 10);
        kruskal.getEdges()[1] = new EdgeBFS(0, 2, 6);
        kruskal.getEdges()[2] = new EdgeBFS(0, 3, 5);
        kruskal.getEdges()[3] = new EdgeBFS(1, 3, 15);
        kruskal.getEdges()[4] = new EdgeBFS(2, 3, 4);

        //wywołujemy algorytm Kruskala.
        kruskal.KruskalMST();

        //Dijkstry
        int V1 = 5; //liczba wierzchołków w grafie
        int source = 0; //wierzchołek źródłowy

        //inicjalizacja listy sąsiedztwa
        List<List<NodeDijkstra>> adj = new ArrayList<>();
        for (int i = 0; i < V1; i++) {
            adj.add(new ArrayList<>());
        }

        //dodanie krawędzi do listy sąsiedztwa
        adj.get(0).add(new NodeDijkstra(1, 9));
        adj.get(0).add(new NodeDijkstra(2, 6));
        adj.get(0).add(new NodeDijkstra(3, 5));
        adj.get(0).add(new NodeDijkstra(4, 3));

        adj.get(2).add(new NodeDijkstra(1, 2));
        adj.get(2).add(new NodeDijkstra(3, 4));

        //wykonanie algorytmu Dijkstry
        Dijkstry dpq = new Dijkstry(V1);
        dpq.dijkstra(adj, source);

        //wyświetlenie najkrótszych ścieżek
        System.out.println("Dijkstry - Najkrótsza ścieżka od węzła:");
        for (int i = 0; i < dpq.getDistance().length; i++) {
            System.out.println(source + " do " + i + " to " + dpq.getDistance()[i]);
        }

        //FordBellman
        int V2 = 5; //liczba wierzchołków w grafie

        //tworzenie obiektu klasy FordBellman
        FordBellman graph = new FordBellman(V2);

        //dodawanie krawędzi do grafu
        graph.addEdge(0, 1, -1);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 2);
        graph.addEdge(1, 4, 2);
        graph.addEdge(3, 2, 5);
        graph.addEdge(3, 1, 1);
        graph.addEdge(4, 3, -3);

        //wywołanie metody bellmanFord z obiektu grafu, żeby znaleźć najkrótsze ścieżki od danego źródła do wszystkich wierzchołków
        graph.bellmanFord(0);

        //FloydWarshall
        int[][] graph1 = { {0,5, INF, 10}, {INF, 0, 3, INF}, {INF, INF, 0, 1}, {INF, INF, INF, 0} };
        int V3 = graph1.length;

        //wykonanie algorytmu Floyda-Warshalla
        FloydWarshall.floydWarshall(graph1, V3);

    }
}
