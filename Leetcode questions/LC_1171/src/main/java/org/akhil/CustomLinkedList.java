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

    public void removeZeroSumSublists() {
        ListNode dummy = new ListNode(0);
        dummy.next = this.head;
        ListNode pointer1 = dummy;
        ListNode pointer2 = this.head;
        int sum = 0;

        while(pointer2 != null){
            sum = sum + pointer2.value;
            pointer2 = pointer2.next;
            if(sum == 0){
                pointer1.next = pointer2;
            }
            if(pointer2 == null) {
                pointer1 = pointer1.next;
                if(pointer1 != null){
                    pointer2 = pointer1.next;
                }
                sum = 0;
            }
        }
        this.head = dummy.next;
    }

    private class ListNode{
        private int value;
        private ListNode next;

        public ListNode(int value){
            this.value = value;
        }
    }
}
