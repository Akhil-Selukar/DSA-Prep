package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // Solution 1 - Accepted but not efficient (O(kN)/O(1)) where k is number of linkedLists and N is average number of elements in the list.
//    public ListNode mergeKLists(ListNode[] lists) {
//        if(lists.length == 0) return null;
//        if(lists.length == 1){
//            return lists[0];
//        }
//
//        ListNode temp = new ListNode(0);
//        ListNode res = temp;
//        ListNode l1 = lists[0];
//
//        for(int i=1; i<lists.length; i++){
//            ListNode l2 = lists[i];
//
//            while(l1 != null && l2 != null){
//                if(l1.val < l2.val){
//                    temp.next = l1;
//                    l1 = l1.next;
//                } else {
//                    temp.next = l2;
//                    l2 = l2.next;
//                }
//                temp = temp.next;
//            }
//
//            while(l1 != null){
//                temp.next = l1;
//                l1 = l1.next;
//                temp = temp.next;
//            }
//
//            while(l2 != null){
//                temp.next = l2;
//                l2 = l2.next;
//                temp = temp.next;
//            }
//
//            l1 = res.next;
//            temp = new ListNode(0);
//            res = temp;
//        }
//
//        return l1;
//    }


    // Solution 1.1 - Minute change but time reduced to half on leetcode. (O(kN)/O(1)) where k is number of linkedLists and N is average number of elements in the list.
//    public ListNode mergeKLists(ListNode[] lists) {
//        if(lists.length == 0) return null;
//        if(lists.length == 1){
//            return lists[0];
//        }
//
//        ListNode temp = new ListNode(0);
//        ListNode res = temp;
//        ListNode l1 = lists[0];
//
//        for(int i=1; i<lists.length; i++){
//            ListNode l2 = lists[i];
//
//            while(l1 != null && l2 != null){
//                if(l1.val < l2.val){
//                    temp.next = l1;
//                    l1 = l1.next;
//                } else {
//                    temp.next = l2;
//                    l2 = l2.next;
//                }
//                temp = temp.next;
//            }
//
//            if(l1 != null){                 // if l1 is not null then l2 must be null and we just want to append all values from l1 further so if e=we attach current l1 tail to temp that will do.
//                temp.next = l1;
//                temp = temp.next;
//            }
//
//            if(l2 != null){                 // same reason as that of above.
//                temp.next = l2;
//                temp = temp.next;
//            }
//
//            l1 = res.next;
//            temp = new ListNode(0);
//            res = temp;
//        }
//
//        return l1;
//    }


    // solution 2 - divide and conquer first add l1+l2, l3+l4, and so on and store the results in a temp list. then again perform same operation till we are left with only 1 list which will be the final result of merge operation.
    //O(N log(K))/ O(K) where K is number of lists and N is the number of nodes
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        if(lists.length == 1){
            return lists[0];
        }

        while(lists.length > 1){
            List<ListNode> temp = new ArrayList<>();
            for(int i=0; i<lists.length; i+=2){
                ListNode l1 = lists[i];
                ListNode l2 = i+1 < lists.length ? lists[i+1] : null;
                temp.add(mergeHelper(l1, l2));
            }
            lists = temp.toArray(new ListNode[0]);
        }
        return lists[0];
    }

    private ListNode mergeHelper(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode();
        ListNode res = dummy;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                dummy.next = l1;
                l1 = l1.next;
            } else {
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }

        if(l1 != null){
            dummy.next = l1;
        }

        if(l2 != null){
            dummy.next = l2;
        }

        return res.next;
    }
}
