package org.akhil;

import java.util.Stack;

public class Solution {

    // Solution 1 - reversal of linkedList (O(N)/O(1)) (efficient approach)
//    public int pairSum(ListNode head) {
//        ListNode slow = head;
//        ListNode fast = head;
//        ListNode prev = null;
//
//        while (fast != null && fast.next != null) {
//            fast = fast.next.next;
//            prev = slow;
//            slow = slow.next;
//        }
//
//        ListNode tempTail = slow;
//        ListNode tempPrev = prev;
//        ListNode nextNode = slow.next;
//
//        while (slow != null) {
//            slow.next = prev;
//            prev = slow;
//            slow = nextNode;
//            nextNode = slow == null ? null : slow.next;
//        }
//        tempPrev.next = prev;
//        tempTail.next = slow;
//
//        int max = Integer.MIN_VALUE;
//
//        while (prev != null) {
//            max = Math.max(max, head.val + prev.val);
//            prev = prev.next;
//            head = head.next;
//        }
//        return max;
//    }

    // Solution 2 - Using stack (O(N)/O(N)) Not a good approach
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }

        Stack<Integer> stack = new Stack<>();

        while(slow != null){
            stack.push(slow.val);
            slow = slow.next;
        }

        int max = Integer.MIN_VALUE;
        while(!stack.isEmpty()){
            max = Math.max(max, head.val+stack.pop());
            head = head.next;
        }

        return max;
    }

    private class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
