package org.dsaprep;

public class CustomLinkedList {

    private ListNode head;
    private ListNode tail;
    private int size;

    public CustomLinkedList(){
        this.size = 0;
    }

    public void addNumberAtEnd(int value){
        ListNode node = new ListNode(value);
        if(this.head == null){
            this.head = node;
            this.tail = node;
            this.size++;
            return;
        }
        this.tail.next = node;
        this.tail = this.tail.next;
        this.size++;
    }

    public void reverse(){
        reverseHelper(this.head);
    }
    private void reverseHelper(ListNode node){
        // Just traverse till the end of the list.
        if(node == this.tail){
            this.head = this.tail;      // at the end of the list set head (i.e. existing tail becomes the head in reversed list.)
            return;                     // start traversing back through the recursion calls.
        }
        reverseHelper(node.next);

        // while returning from the recursion calls
        this.tail.next = node;          // while traversing back reverse the direction i.e. tail.next will become the previous node (i.e. node in this recursion call)
        this.tail = node;               // set that node as new tail (i.e. now your tail is moving to the left)
        this.tail.next = null;          // consider this as the last element to the left and set the tail.next as null as for actual tail, tail.next will be null.
    }

    public void display(){
        ListNode temp = this.head;
        while(temp != null){
            System.out.print(temp.value+" -> ");
            temp = temp.next;
        }
        System.out.print("END");
    }

    private class ListNode{
        private int value;
        private ListNode next;

        public ListNode(int value){
            this.value = value;
        }
    }
}
