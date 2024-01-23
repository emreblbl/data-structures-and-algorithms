package com.practice.data.structure.algorithms.queue;

public class Queue {
    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    public int getLength() {
        return length;
    }

    private Node first, last;
    int length;

    public Queue(int value) {
        Node node = new Node(value);
        first = last = node;
        length++;
    }

    public void printQueue() {
        Node temp = first;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void enqueue(int value) {
        Node node = new Node(value);
        if (first == null) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
        length++;
    }
    public Node dequeue(){
        if(first ==null) return null;
        Node temp = first;
        if(length ==1){
            first= last =null;
        }else {
            first= first.next;
            temp.next=null;
        }
        length--;
        return temp;
    }

    class Node {
        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }

        Node next;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

}
