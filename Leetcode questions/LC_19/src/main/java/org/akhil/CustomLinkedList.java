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

    public void display(){
        ListNode temp = this.head;
        while(temp != null){
            System.out.print(temp.value+" -> ");
            temp = temp.next;
        }
        System.out.print("END");
        System.out.println();
    }

    // Solution - 1====================
    public void removeNthFromEnd(int n) {
        int size = getSize(this.head);
        if(size == 1){
            return; // null
        }
        if(n == size){
            this.head = this.head.next;
            return; //head
        }
        ListNode previousNode = getNodeAtIndex(size-n);
        previousNode.next = previousNode.next.next;

    }

    private ListNode getNodeAtIndex(int index) {
        ListNode temp = this.head;
        for(int i=1; i<index; i++){
            temp = temp.next;
        }
        return temp;
    }

    private int getSize(ListNode head) {
        int size = 0;
        while(head != null){
            size++;
            head = head.next;
        }
        return size;
    }
    // Solution - 2 ====================
    public void removeNthFromEnd_2(int n) {
        ListNode temp = new ListNode(0);        // created a dummy node to attach before head;
        temp.next = this.head;
        ListNode pointerNode = temp;

        for(int i=0; i<n; i++){
            this.head = this.head.next;             // moving head n nodes ahead;
        }

        while(this.head != null){                   // moving pointerNode and head ahead, when head is null the pointerNode will be exactly at the node previous to the node to be deleted.
            this.head = this.head.next;
            pointerNode = pointerNode.next;
        }

        pointerNode.next = pointerNode.next.next;
        this.head = temp.next;
//        return temp.next;                         // in leetcode we will have to return the head. Here we have attached the
                                                    // temp node before head. So if head is the one which was deleted then temp.next will have
                                                    // new head or if head was the only element in list then temp.next will point to null.
    }

    private class ListNode{
        private int value;
        private ListNode next;

        public ListNode(int value){
            this.value = value;
        }
    }
}
