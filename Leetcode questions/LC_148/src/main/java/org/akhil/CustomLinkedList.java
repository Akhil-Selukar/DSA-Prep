package org.akhil;

public class CustomLinkedList {

    private ListNode head;
    private ListNode tail;

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode midNode = findMiddle(head);
        ListNode leftPart = sortList(head);
        ListNode rightPart = sortList(midNode);

        return mergeTwoLists(leftPart, rightPart);
    }

    private ListNode mergeTwoLists(ListNode first, ListNode second){
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        while(first != null && second != null){
            if(first.value < second.value){
                tail.next = first;
                first = first.next;
                tail = tail.next;
            } else {
                tail.next = second;
                second = second.next;
                tail = tail.next;
            }
        }

        while(first != null){
            tail.next = first;
            first = first.next;
            tail = tail.next;
        }

        while(second != null){
            tail.next = second;
            second = second.next;
            tail = tail.next;
        }
        return dummyHead.next;
    }

    private ListNode findMiddle(ListNode head){
        ListNode midPrevious = null;
        while(head != null && head.next != null){
            midPrevious = (midPrevious==null)?head : midPrevious.next;
            head = head.next.next;
        }
        ListNode mid = midPrevious.next;
        midPrevious.next = null;
        return mid;
    }

    private class ListNode{
        private int value;
        private ListNode next;

        public ListNode(){
        }
    }
}
