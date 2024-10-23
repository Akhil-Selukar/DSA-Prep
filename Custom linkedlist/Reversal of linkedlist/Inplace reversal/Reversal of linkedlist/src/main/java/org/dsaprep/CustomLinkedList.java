package org.dsaprep;

public class CustomLinkedList {

    private ListNode head;
    private ListNode tail;
    private int size;

    public CustomLinkedList() {
        this.size = 0;
    }

    public void addElementAtEnd(int value) {
        ListNode node = new ListNode(value);
        if (this.head == null) {
            this.head = node;
            this.tail = node;
            this.size++;
            return;
        }

        this.tail.next = node;
        this.tail = node;
        this.size++;
    }

    public void display() {
        ListNode temp = this.head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.print("END");
    }

    public void reverse() {
        if(this.size < 2){
            return;
        }
        ListNode previousNode = null;
        ListNode presentNode = this.head;
        ListNode nextNode = this.head.next;

        while (presentNode != null) {
            presentNode.next = previousNode;
            previousNode = presentNode;
            presentNode = nextNode;
            if (nextNode != null) {
                nextNode = nextNode.next;
            }
        }
        this.head = previousNode;
    }

    private class ListNode {
        private int value;
        private ListNode next;
        public ListNode(int value) {
            this.value = value;
        }
    }
}
