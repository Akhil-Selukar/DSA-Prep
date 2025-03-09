package org.akhil;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    // O(M+N)/O(M) where N is nodes in list and M is number of elements in nums array;
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<Integer>();

        for(int num:nums){
            set.add(num);
        }

        int count = 0;
        while(head != null){
            if(set.contains(head.val)){
                count++;
                while(head != null && set.contains(head.val)){
                    head = head.next;
                }
            } else {
                head = head.next;
            }
        }

        return count;
    }


    class ListNode{
        private int val;
        private ListNode next;

        public ListNode(int val){
            this.val = val;
        }
    }
}
