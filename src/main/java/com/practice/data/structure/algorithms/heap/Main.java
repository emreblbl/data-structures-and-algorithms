package com.practice.data.structure.algorithms.heap;

public class Main {


    public static void main(String[] args) {
        Heap heap = new Heap();

        heap.insert(95);
        heap.insert(75);
        heap.insert(80);
        heap.insert(55);
        heap.insert(60);
        heap.insert(50);
        heap.insert(65);

        System.out.println(heap.printHeap());

        heap.remove();

        System.out.println(heap.printHeap());

        heap.remove();

        System.out.println(heap.printHeap());

    }

}
