package com.practice.data.structure.algorithms.stack;

public class Stack<T> {
    public Node top;

    @Override
    public String toString() {
        return "Stack{" +
                "top=" + top +
                ", height=" + height +
                '}';
    }

    public int height;

    class Node {
        @Override
        public String toString() {
            return "Node{" +
                    "next=" + next +
                    ", value=" + value +
                    '}';
        }

        Node next;

        public Node(int value) {
            this.value = value;
        }

        int value;
    }

    Stack(int value) {
        Node node = new Node(value);
        top = node;
        height = 1;
    }

    public void push(int value) {
        Node node = new Node(value);
        if (height == 0) {
            top = node;
        } else {
            node.next = top;
            top = node;

        }
        height++;
    }
    public Node pop(){
        if(height ==0) return null;
        Node temp = top;
        top = top.next;
        temp.next=null;
        height--;
        return temp;
    }



}
