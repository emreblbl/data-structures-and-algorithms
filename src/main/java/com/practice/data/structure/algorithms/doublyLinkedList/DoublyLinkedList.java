package com.practice.data.structure.algorithms.doublyLinkedList;

public class DoublyLinkedList {

    private Node tail;
    private Node head;
    private int length;

    public class Node {
        int value;
        Node prev;
        Node next;

        public Node(int value) {
            this.value = value;
        }

    }

    public DoublyLinkedList(int value) {
        Node node = new Node(value);
        head = node;
        tail = node;
        length = 1;
    }


    public void append(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            tail = node;
        }
        tail.next = node;
        node.prev = tail;
        tail = node;
        length++;
    }

    public Node removeLast() {
        if (head == null) {
            return null;
        }

        Node temp = tail;
        tail = tail.prev;
        temp.prev = null;
        tail.next = null;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    public void prepend(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        length++;
    }

    public Node removeFirst() {
        Node temp = head;
        if (head == null) {
            return null;
        }
        if (length == 1) {
            head = tail = null;
        } else {
            head = head.next;
            temp.next = null;
            head.prev = null;
        }
        length--;
        return temp;
    }

    public Node get(int index){
        if(index < 0 || index >= length) return  null;
        Node temp ;
        if(index < length/2){
            temp = head;
            for(int i = 0; i <index; i ++){
                temp = head.next;
            }
        }else {
            temp = tail;
            for(int i = length-1;i > index ; i--){
                temp = temp.prev;
            }
        }
        return temp;

    }

    public boolean set(int index, int value){
        Node temp = get(index);
        if(temp ==null){
            return false;
        }else{
            temp.value = value;
            return true;
        }
    }
    public boolean insert(int index, int value){
        if(index <0 || index> length) return false;
        else if(index ==0) prepend(value);
        else if(index == length) append(value);
        else {
            Node node = new Node(value);
            Node before = get(index - 1);
            Node after = before.next;
            node.prev = before;
            node.next = after;
        }
        length++;
        return true;
    }

}
