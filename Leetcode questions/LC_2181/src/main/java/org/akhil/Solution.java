package org.akhil;

public class Solution {

    // O(N)/O(1)
    public ListNode mergeNodes(ListNode head) {
        ListNode prev = head;
        ListNode prevTail = null;
        ListNode curr = head.next;

        while(curr != null){
            int sum = 0;
            while(curr.val != 0){
                sum += curr.val;
                curr = curr.next;
            }

            prev.val = sum;
            prev.next = curr;
            prevTail = prev;
            prev = curr;
            curr = curr.next;
        }

        prevTail.next = null;
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
