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

    public void deleteMiddle() {
        ListNode headNode = this.head;
        int size = 0;
        while(headNode != null){
            headNode = headNode.next;
            size++;
        }

        headNode = this.head;

        for(int i=0; i<(size/2)-1; i++){
            headNode = headNode.next;
        }

        if(headNode.next != null){
            headNode.next = headNode.next.next;
        } else {
            this.head = null;
        }
    }

    public void deleteMiddleImproved() {
        if(this.head == null){
            return;
        }
        ListNode fastPointer = this.head;
        ListNode slowPointer = this.head;
        ListNode previousToSlow = null;

        while(fastPointer != null && fastPointer.next != null){
            fastPointer = fastPointer.next.next;
            previousToSlow = slowPointer;
            slowPointer = slowPointer.next;
        }

        if(previousToSlow == null){
//            return slowPointer.next;
            this.head = slowPointer.next;
        } else {
            previousToSlow.next = slowPointer.next;
//            return this.head;
        }
    }

    private class ListNode{
        private int value;
        private ListNode next;

        public ListNode(int value){
            this.value = value;
        }
    }
}
