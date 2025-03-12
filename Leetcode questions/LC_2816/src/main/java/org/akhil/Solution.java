package org.akhil;

import java.util.Stack;

public class Solution {
    // Solution 1 - using stack (O(N)/O(N))
//    public ListNode doubleIt(ListNode head) {
//        Stack<Integer> stack = new Stack();
//        while(head != null){
//            stack.push(head.val);
//            head = head.next;
//        }
//
//        ListNode dummy = new ListNode(0);
//        ListNode temp = dummy;
//        int carry = 0;
//        while(!stack.isEmpty() || carry > 0){
//            int value = stack.isEmpty() ? 0 : stack.pop();
//            int doubled = (value*2) + carry;
//
//            temp.next = new ListNode(doubled % 10);
//            carry = doubled / 10;
//            temp = temp.next;
//        }
//
//        temp = null;
//        ListNode current = dummy.next;
//
//        while(current != null){
//            ListNode next = current.next;
//            current.next = temp;
//            temp = current;
//            current = next;
//        }
//
//        return temp;
//    }

    // Solution 2 - Without using stack (O(N)/O(1))
    public ListNode doubleIt(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy;
        ListNode right = head;

        while (right != null) {
            int num = right.val;

            if (num * 2 >= 10) {
                left.val = left.val + 1;
                right.val = (num * 2) % 10;
            } else {
                right.val = num * 2;
            }

            left = left.next;
            right = right.next;
        }

        return dummy.val == 0 ? dummy.next : dummy;
    }
}
