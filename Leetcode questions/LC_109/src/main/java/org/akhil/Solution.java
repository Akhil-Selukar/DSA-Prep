package org.akhil;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // Solution 1 - Using map (O(N)/O(N))

//    Map<Integer, Integer> map = new HashMap<>();
//    public TreeNode sortedListToBST(ListNode head) {
//        int counter = 0;
//        while(head != null){
//            map.put(counter, head.val);
//            head = head.next;
//            counter++;
//        }
//
//        return helper(0, counter-1);
//    }
//
//    private TreeNode helper(int start, int end){
//        if(start>end){
//            return null;
//        }
//
//        int mid = start + (end-start)/2;
//
//        TreeNode node = new TreeNode(map.get(mid));
//
//        node.left = helper(start, mid-1);
//        node.right = helper(mid+1, end);
//
//        return node;
//    }


    // Solution 2 - using two pointers - (O(NlogN)/O(N))
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return new TreeNode(head.val);
        }

        ListNode slow = head;
        ListNode fast = head.next.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.next.val);
        ListNode rightHead = slow.next.next;
        slow.next = null;

        root.left = sortedListToBST(head);
        root.right = sortedListToBST(rightHead);

        return root;
    }
}
