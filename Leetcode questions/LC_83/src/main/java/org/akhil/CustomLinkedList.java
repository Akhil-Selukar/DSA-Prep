package org.akhil;

public class CustomLinkedList {

    private ListNode head;
    private ListNode tail;
    private int size;

    public CustomLinkedList() {
        this.size = 0;
    }

    public void addElement(int val){
        ListNode node = new ListNode(val);
        if(this.head == null){
            this.head = node;
            this.tail = node;
            this.size+=1;
            return;
        }

        this.tail.next = node;
        this.tail = node;
        this.size++;
    }

    public void display(){
        if(this.size == 0){
            System.out.println("END");
            return;
        }
        ListNode temp = this.head;
        while(temp != null){
            System.out.print(temp.val+" -> ");
            temp = temp.next;
        }
        System.out.print("END");
    }

    // O(N)/O(1)
    public void removeDuplicate(){
        ListNode temp = this.head;
        while(temp.next != null){
            if(temp.next.val == temp.val){
                temp.next = temp.next.next;
                this.size--;
            } else {
                temp = temp.next;
            }
        }
        this.tail = temp;
        this.tail.next = null;
    }


    // Solution for leetcode
   /* public ListNode deleteDuplicates(ListNode head){
        if(head == null){
            return head;
        }
        ListNode temp = head;                   // use given head
        while(temp.next != null){
            if(temp.next.val == temp.val){
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;                    // whenever leetcode ask to return node it asks for head.
    }*/

    private class ListNode {
        private int val;
        private ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
