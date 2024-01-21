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

    public Node get(int index) {
        if (index < 0 || index >= length) return null;
        Node temp;
        if (index < length / 2) {
            temp = head;
            for (int i = 0; i < index; i++) {
                temp = head.next;
            }
        } else {
            temp = tail;
            for (int i = length - 1; i > index; i--) {
                temp = temp.prev;
            }
        }
        return temp;

    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp == null) {
            return false;
        } else {
            temp.value = value;
            return true;
        }
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length) return false;
        else if (index == 0) prepend(value);
        else if (index == length) append(value);
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

    public void append2(int value) {
        Node node = new Node(value);

        if (head == null) {
            head = tail = node;
        }
        node.prev = tail;
        tail.next = node;
        tail = node;
        length++;
    }

    public Node removeLast2() {
        if (head == null) return null;
        Node temp;
        if (length == 1) {
            temp = tail;
            head = tail = null;
        } else {
            temp = tail;
            tail = tail.prev;
            temp.next = null;
            tail.next = null;
        }
        length--;
        return temp;
    }

    public void prepend2(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = head.prev;
        }
        length++;
    }

    public Node removeFirst2() {
        if (head == null) return null;
        Node temp;
        if (length == 1) {
            temp = head;
            head = tail = null;
        } else {
            temp = head;
            head = head.next;
            head.prev = null;
            temp.next = null;
        }
        length--;
        return temp;
    }

    public Node get(int index) {
        if (head == null) return null;
        Node temp;
        if (length / 2 >= index) {
            temp = tail;
            for (int i = length - 1; i > index; i--) {
                temp = temp.prev;
            }
        } else {
            temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        }
        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp == null) return false;
        temp.value = value;
        return true;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length) return null;
        if (index == 0) prepend(value);
        else if (index == length) append(value);
        else {
            Node before = get(index - 1);
            Node after = before.next;
            Node node = new Node(value);
            before.next = node;
            node.prev = before;
            node.next = after;
            after.prev = node;
            length++;
        }
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) return null;

        Node temp;
        if (index == 0) return removeFirst();
        else if (index == length - 1) return removeLast();
        else {
            temp = get(index);
            Node before = temp.prev;
            Node after = temp.next;
            before.next = after;
            after.prev = before;
            temp.next = null;
            temp.prev = null;
        }
        length--;
        return temp;
    }

    public void swapFirstLast() {
        if (length < 2) {
            return;
        }
        int temp = head.value;
        head.value = tail.value;
        tail.value = temp;
    }

    public void reverse() {
        if (length < 2) return;
        Node current = head, temp;
        while(current !=null){
            temp = current.next;

            current.next = current.prev;
            current.prev = temp;


            current = temp;
        }
    temp =head;
    head =tail;
    tail =temp;
}

public boolean isPalindrome(){
        if(head ==null){
            return true;
        }
        Node tempHead = head, tempTail = tail;
        for(int i=0;i<length/2;i++){
            if(tempTail.value !=tempHead.value) return false;
            tempTail = tempTail.prev;
            tempHead = tempHead.next;
        }
        return true;
}

    public void swapPairs(){
        if(length <=1) return;

        Node before = null;
        Node current = head;
        Node next = current.next;

        head= next;

        while(next !=null){
            current.next= next.next;
            current.prev = next;

            next.next= current;
            next.prev = before;

            if(before !=null)before.next = next;

            // Prepare for the next pair
            before = current;
            current = current.next;

            // Check if there is a next pair to swap
            if (current != null) {
                next = current.next;
            } else {
                break; // Exit the loop if there are no more pairs
            }
        }
        // Handle the case where the list has an odd number of nodes
        if (current != null) {
            current.prev = before;
        }
    }

}
