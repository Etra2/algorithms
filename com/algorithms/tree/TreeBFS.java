package com.algorithms.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeBFS {
    //metoda BFS przeszukuje drzewo wszerz
    public void breadthFirstSearch(TreeNodeBFS root) {
        if (root == null) {
            return;
        }

        //utworzenie kolejki do przechowywania wierzchołków "do odwiedzenia"
        Queue<TreeNodeBFS> queue = new LinkedList<>();
        //dodanie korzenia do kolejki
        queue.add(root);

        //pętla wykonuje sie dopóki kolejka nie jest pusta
        while (!queue.isEmpty()) {
            //pobranie wierzchołka z kolejki
            TreeNodeBFS node = queue.poll();
            //wyświetlanie wartosci wierzchołka
            System.out.println(node.vertex + " ");

            //dodanie lewego dziecka do kolejki, jeśli istnieje
            if (node.left != null) {
                queue.add(node.left);
            }
            //dodanie prawego dziecka do kolejki, jeśli istnieje
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
}