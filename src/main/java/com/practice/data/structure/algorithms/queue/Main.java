package com.practice.data.structure.algorithms.queue;

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue(7);

        System.out.println(queue.getFirst());
        System.out.println(queue.getLast());
        System.out.println(queue.length);
        queue.printQueue();

        queue.enqueue(10);

        System.out.println(queue.length);
        System.out.println(queue.getLast());

        queue.dequeue();
        System.out.println(queue.length);
        System.out.println(queue.getLast());
        queue.dequeue();
        System.out.println(queue.length);
        System.out.println(queue.getLast());

    }
}
