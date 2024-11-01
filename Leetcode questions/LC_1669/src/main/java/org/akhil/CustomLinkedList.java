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

    public void mergeInBetween(int a, int b, CustomLinkedList list2) {
        ListNode list1Head = this.head;
        ListNode list2Head = list2.head;

        ListNode list1Pointer = list1Head;

        for(int i=1; i<a; i++){
            list1Pointer = list1Pointer.next;
        }
        ListNode tempList1 = list1Pointer.next;
        list1Pointer.next = list2Head;

        while(list2Head.next != null){
            list2Head = list2Head.next;
        }

        int nodesToDelete = b-a+1;
        for(int i=0; i<nodesToDelete; i++){
            tempList1 = tempList1.next;
        }
        list2Head.next = tempList1;
    }

    private class ListNode{
        private int value;
        private ListNode next;

        public ListNode(int value){
            this.value = value;
        }
    }
}
