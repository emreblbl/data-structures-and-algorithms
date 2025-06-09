package com.practice.data.structure.algorithms.leetcode;

public class SwapNodesInPairs {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }



    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head;
        while (current != null && current.next != null) {
            int temp          = current.val;
            current.val       = current.next.val;
            current.next.val  = temp;
            current           = current.next.next;
        }

        return head;
    }

    public static void main(String[] args) {
        SwapNodesInPairs obj = new SwapNodesInPairs();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode swappedHead = obj.swapPairs(head);

        // Print the swapped list
        while (swappedHead != null) {
            System.out.print(swappedHead.val + " ");
            swappedHead = swappedHead.next;
        }
        // Output: 2 1 4 3
    }
}
