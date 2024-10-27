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

    public void swapNodes(int k) {
        int length = findLength(this.head);

        ListNode firstNode = getNodeAtIndex(this.head,k);
        ListNode secondNode = getNodeAtIndex(this.head,length-(k-1));

        int firstVal = firstNode.value;
        firstNode.value = secondNode.value;
        secondNode.value = firstVal;
        // return head;
    }

    private ListNode getNodeAtIndex(ListNode head, int index) {
        ListNode temp = head;
        for(int i=1; i<index; i++){
            temp = temp.next;
        }
        return temp;
    }

    private int findLength(ListNode head) {
        int length = 0;
        while(head != null){
            length++;
            head = head.next;
        }
        return length;
    }

    private class ListNode{
        private int value;
        private ListNode next;

        public ListNode(int value){
            this.value = value;
        }
    }
}
