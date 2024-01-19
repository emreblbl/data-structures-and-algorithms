package com.practice.data.structure.algorithms.linkedList;


public class LinkedList {


    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length++;

    }

    private int length;
    private Node head;
    private Node tail;


    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = tail = newNode;
        }
        if (length > 0) {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast() {
        if (head == null) {
            return null;
        }
        Node temp = head;
        if (head == tail) {
            head = tail = null;
        } else {
            Node prev = null;
            while (temp.next != null) {
                prev = temp;
                temp = temp.next;
            }
            tail = prev;
            tail.next = null;
        }
        length--;
        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = tail = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }


    public Node removeFirst() {
        if (head == null) {
            return null; // List is empty
        }

        Node temp = head;
        head = head.next;

        if (head == null) {
            tail = null; // List became empty after removal
        }

        temp.next = null; // Disconnect the removed node
        length--;
        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, int value) {
        if (index < 0 || index >= length) {
            return false;
        }
        if (index == length - 1) {
            tail.value = value;
            return true;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.value = value;
        return true;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length) {
            return false;
        }
        Node newNode = new Node(value);
        if (index == 0) {
            prepend(value);
        } else if (index == length) {
            tail.next = new Node(value);
            return true;
        } else {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
        length++;
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length || length == 0) {
            return null;
        }

        Node temp;
        if (tail == head) {
            temp = head;
            head = tail = null;
        } else if (index == 0) {
            temp = head;
            head = head.next;
            if (head == null) {
                tail = null; // List becomes empty
            }
        } else {
            Node pre = get(index - 1);
            temp = pre.next;
            pre.next = temp.next;
            if (index == length - 1) {
                tail = pre;
            }
        }

        length--;
        if (temp != null) {
            temp.next = null;
        }
        return temp;
    }

    public void reverse() {
        if (length == 0 || length == 1) {
            return;
        }

        tail = head;
        Node current = head;
        Node previous = null;
        Node next = null;

        while (current != null) {
            next = current.next; // Store next node
            current.next = previous; // Reverse the link
            previous = current; // Move previous to current
            current = next; // Move to next node in the original list
        }

        head = previous;
    }

    public Node findMiddleNode() {
        Node slowPointer = head;
        Node fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer;
    }

    public boolean hasLoop() {
        Node slowPointer = head;
        Node fastPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if (slowPointer == fastPointer) {
                return true;
            }
        }
        return false;
    }

    public Node findKthFromEnd(int k) {
        Node leftPointer = head;
        Node rightPointer = head;

        if (head== null) {
            return null;
        }
        if(head.next == null){
            return head;
        }

        for (int i = 0; i < k; i++) {
            if (rightPointer.next != null) {
                rightPointer = rightPointer.next;
            }else {
                return null;
            }
        }
        while(rightPointer.next !=null){
            leftPointer  = leftPointer.next;
            rightPointer = rightPointer.next;
        }

        return leftPointer;
    }


    public void partitionList(int x){
        Node dummy1 = new Node(0), dummy2 = new Node(0);
        Node pointer1 = dummy1, pointer2  = dummy2, header2=null,current;
        if(head == null){
            return;
        }
        current = head;
        while(current.next !=null){
            if(current.value < x){
                pointer1.next = current;
                pointer1 = current;

            }else {
                pointer2.next = current;
                pointer2 =current;
            }
        }
        pointer2.next =null;
        pointer1.next = dummy2.next;
        head = dummy1.next;
    }

    public void removeDuplicates(){
        Node current = head;
        while(current !=null ){
            Node runner =current.next;
            Node prev = current;
            while(runner !=null){
                if(runner.value == current.value){
                    prev.next = runner.next;
                    length--;
                }else{
                    prev= prev.next;
                }
                runner = runner.next;
            }
            current = current.next;
        }
    }

    public int binaryToDecimal(){
        Node current= head;
        int count = 0;
        int power = length-1;
        while(current !=null){
            count += (current.value)*Math.pow(2,power);
            current = current.next;
            power--;
        }
        return count;
    }

    public void reverseBetween(int startIndex, int endIndex) {
        if (head == null || startIndex >= endIndex) {
            return;
        }

        Node dummy = new Node(0);
        dummy.next = head;
        Node prevNode = dummy;

        // Move prevNode to the node just before the start of the reversal
        for (int i = 0; i < startIndex; i++) {
            prevNode = prevNode.next;
        }

        Node current = prevNode.next;
        Node next = null;

        // Perform the actual reversal
        for (int i = 0; i < endIndex - startIndex; i++) {
            next = current.next;
            current.next = next.next;
            next.next = prevNode.next;
            prevNode.next = next;
        }

        if (startIndex == 0) {
            head = dummy.next; // Update head if necessary
        }
    }


}


