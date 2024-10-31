package org.akhil;

public class CustomLinkedList {

    private ListNode head;
    private ListNode tail;

    public void addElementAtLast(int value){
        ListNode node = new ListNode(value);
        if(this.head == null){
            this.head = node;
            this.tail = node;
            return;
        }

        this.tail.next = node;
        this.tail = node;
    }

    public void partition(int x) {
        ListNode smallerList = new ListNode(0);
        ListNode greatreList = new ListNode(0);
        ListNode smallerHead = smallerList;
        ListNode greatreHead = greatreList;

        ListNode currentNode = this.head;

        while(currentNode != null){
            if(currentNode.value < x){
                smallerHead.next = currentNode;
                smallerHead = smallerHead.next;
            } else {
                greatreHead.next = currentNode;
                greatreHead = greatreHead.next;
            }
            currentNode = currentNode.next;
        }
        greatreHead.next = null;
        smallerHead.next = greatreList.next;


        this.head = smallerList.next;
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
