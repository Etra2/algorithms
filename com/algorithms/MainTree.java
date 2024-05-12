package com.algorithms;

import com.algorithms.tree.Heap;
import com.algorithms.tree.RedBlackTree;
import com.algorithms.tree.TreeBFS;
import com.algorithms.tree.TreeNodeBFS;

public class MainTree {
    public static void main(String[] args) {

        //BFSTree
        //tworzenie przykładowego drzewa
        TreeNodeBFS root = new TreeNodeBFS(1);
        root.left = new TreeNodeBFS(2);
        root.right = new TreeNodeBFS(3);
        root.left.left = new TreeNodeBFS(4);
        root.left.right = new TreeNodeBFS(5);
        root.right.left = new TreeNodeBFS(6);
        root.right.right = new TreeNodeBFS(7);

        //utworzenie obiektu klasy TreeBFS
        TreeBFS treeBFS = new TreeBFS();
        //wyswietlanie komunikatu
        System.out.println("BFS przechodzenie przez drzewo:");
        //wywołanie metody BFS i przekazanie korzenia drzewa
        treeBFS.breadthFirstSearch(root);

        //Heap
        Heap heap = new Heap(10);
        heap.insert(5);
        heap.insert(3);
        heap.insert(8);
        heap.insert(2);
        heap.insert(7);
        //wyświetlanie
        heap.displayHeap(); //kopiec: 8 7 5 2 3
        //usuwanie korzenia
        heap.removeRoot();
        heap.displayHeap(); //kopiec: 7 3 5 2
        //zmiana priorytetu elemntu o indeksie
        heap.changePriority(2, 10);
        heap.displayHeap(); //kopiec: 10 7 5 2
        //konstruowanie kopca z tablicy
        int[] array = {1, 12, 6, 4, 9};
        heap.buildHeap(array);
        heap.displayHeap(); //kopiec: 12 9 6 1 4
        //sortowanie przez kopcowanie
        heap.heapSort();
        heap.displayHeap(); //kopiec: 1 4 6 9 12

        //RedBlackTree
        RedBlackTree bst = new RedBlackTree();

        //wstawianie
        bst.insert(7);
        bst.insert(3);
        bst.insert(18);
        bst.insert(10);
        bst.insert(22);
        bst.insert(8);
        bst.insert(11);
        bst.insert(26);
        bst.insert(2);
        bst.insert(6);

        //usuwanie
        bst.deleteNode(18);

        //wypisanie drzewa
        bst.printTree();
    }
}
