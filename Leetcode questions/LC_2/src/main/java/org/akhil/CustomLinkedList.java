package org.akhil;

public class CustomLinkedList {

    private ListNode head;
    private ListNode tail;

    public void addElementAtEnd(int value){
        ListNode node = new ListNode(value);
        if(this.head == null){
            this.head = node;
            this.tail = node;
            return;
        }
        this.tail.next = node;
        this.tail = node;
    }

    public ListNode addTwoNumbers(ListNode headL1, ListNode headL2) {
        ListNode ansList = new ListNode(0);
        ListNode tail = ansList;
        int carry = 0;

        while(headL1 != null || headL2 != null || carry != 0){
            int digit1 = headL1 != null? headL1.value:0;
            int digit2 = headL2 != null? headL2.value:0;

            int addition = digit1 + digit2 + carry;
            int ansDigit = addition%10;
            carry = addition/10;

            ListNode ansNode = new ListNode(ansDigit);
            tail.next = ansNode;
            tail = tail.next;

            headL1 = headL1 != null? headL1.next: null;
            headL2 = headL2 != null? headL2.next: null;
        }
        return ansList.next;
    }

    public void display(){
        ListNode temp = this.head;
        while(temp != null){
            System.out.print(temp.value+" -> ");
            temp = temp.next;
        }
        System.out.print("END");
        System.out.println();
    }

    private class ListNode{
        private int value;
        private ListNode next;

        public ListNode(int value){
            this.value = value;
        }
    }
}
