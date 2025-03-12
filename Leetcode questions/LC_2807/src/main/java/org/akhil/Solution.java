package org.akhil;

public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // Time complexity is O(N * log M), where N is the number of nodes in the linked list and M is the maximum value of the nodes.
    // space complexity is O(log M), where M is the maximum value of the nodes.
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curr = head;
        ListNode next = head.next;

        while (next != null) {
            int gcd = getGcd(curr.val, next.val);
            curr.next = new ListNode(gcd, next);
            curr = next;
            next = curr.next;
        }
        return head;
    }

    private int getGcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return getGcd(b % a, a);
    }
}
