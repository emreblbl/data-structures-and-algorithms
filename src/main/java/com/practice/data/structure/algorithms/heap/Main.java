package com.practice.data.structure.algorithms.heap;

public class Main {


    public static void main(String[] args) {
        Heap heap = new Heap();

        heap.insert(10);
        heap.insert(20);
        heap.insert(30);
        heap.insert(40);
        heap.insert(50);
        heap.insert(60);
        heap.insert(70);
        heap.insert(80);
        heap.insert(90);
        heap.insert(100);

        System.out.println(heap.printHeap());
    }

}
