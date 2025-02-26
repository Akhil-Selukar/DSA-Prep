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

    // O(N)/O(1)
    public void swapPairs() {
        if(this.head == null || this.head.next == null){
//            return this.head;
            return;
        }
        ListNode dummy = new ListNode(0);
        ListNode previousNode = dummy;
        ListNode currentNode = this.head;
        ListNode nextNode = currentNode.next;


        while(currentNode != null && currentNode.next != null){
            currentNode.next = nextNode.next;
            previousNode.next = nextNode;
            nextNode.next = currentNode;

            previousNode = previousNode.next.next;
            currentNode = currentNode.next;
            if(nextNode.next != null && nextNode.next.next != null){
                nextNode = nextNode.next.next.next;
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
