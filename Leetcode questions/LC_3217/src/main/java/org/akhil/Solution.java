package org.akhil;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    // Time complexity - O(M+N) where M is size of nums array and N is number of nodes in LinkedList
    // Space complexity - O(M) because of set.
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet();
        for(int num:nums){
            set.add(num);
        }

        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;

        while(head != null){
            if(set.contains(head.val)){
                prev.next = head.next;
                head = head.next;
            } else {
                prev = head;
                head = head.next;
            }
        }
        return dummy.next;
    }
}
