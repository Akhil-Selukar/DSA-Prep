package org.akhil;

import java.util.Stack;

public class Solution {

    // Solution - 1 (O(N)/O(N))
//    public ListNode removeNodes(ListNode head) {
//        Stack<Integer> stack = new Stack();
//
//        ListNode current = head;
//        while(current != null){
//            stack.push(current.val);
//            current = current.next;
//        }
//
//        int largest = stack.pop();
//        current = head;
//        current.val = largest;
//
//        while(!stack.isEmpty()){
//            int element = stack.pop();
//
//            if(element >= largest){
//                current.next.val = element;
//                largest = element;
//                current = current.next;
//            }
//        }
//
//        current.next = null;
//
//        // reverse the LinkedList
//        ListNode dummy = null;
//        current = head;
//
//        while(current != null){
//            ListNode next = current.next;
//            current.next = dummy;
//            dummy = current;
//            current = next;
//        }
//
//        return dummy;
//    }


    // Solution 2 - without using stack (O(N)/O(1))

//    public ListNode removeNodes(ListNode head) {
//
//        // reverse the LinkedList
//        ListNode newHead = reverse(head);
//
//        head = newHead;
//        ListNode temp = head.next;
//
//        while(temp != null){
//            if(head.val <= temp.val){
//                head.next = temp;
//                head = head.next;
//            }
//            temp = temp.next;
//        }
//
//        head.next = null;
//
//        // reverse the LinkedList
//        return reverse(newHead);
//    }
//
//    private ListNode reverse(ListNode head){
//        ListNode dummy = null;
//        ListNode current = head;
//
//        while(current != null){
//            ListNode next = current.next;
//            current.next = dummy;
//            dummy = current;
//            current = next;
//        }
//
//        return dummy;
//    }


    // Solution 2.1 - Slightly optimized (no need to reverse again in the end if we re-arrange the next relation properly.
    public ListNode removeNodes(ListNode head) {

        // reverse the LinkedList
        ListNode newHead = reverse(head);

        head = newHead;
        ListNode temp = head.next;
        head.next = null;

        while(temp != null){
            if(head.val <= temp.val){
                ListNode dummy = temp.next;
                temp.next = head;
                head = temp;
                temp = dummy;
            } else {
                temp = temp.next;
            }
        }

        // head.next = null;

        return head;

    }

    private ListNode reverse(ListNode head){
        ListNode dummy = null;
        ListNode current = head;

        while(current != null){
            ListNode next = current.next;
            current.next = dummy;
            dummy = current;
            current = next;
        }

        return dummy;
    }


    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
