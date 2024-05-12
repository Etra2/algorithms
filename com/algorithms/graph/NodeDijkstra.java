package com.algorithms.graph;

import java.util.*;

//klasa reprezentująca węzeł grafu
public class NodeDijkstra implements Comparator<NodeDijkstra> {
    public int node;
    public int cost;

    public NodeDijkstra() {
    }

    public NodeDijkstra(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compare(NodeDijkstra node1, NodeDijkstra node2) {
        if (node1.cost < node2.cost)
            return -1;
        if (node1.cost > node2.cost)
            return 1;
        return 0;
    }
}
