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
            System.out.print(temp.val+" -> ");
            temp = temp.next;
        }
        System.out.print("END");
        System.out.println();
    }

    public void deleteDuplicates() {
        ListNode dummyNode = new ListNode(0, this.head);
        ListNode previousNode = dummyNode;
        ListNode currentNode = this.head;

        while(currentNode != null) {
            int value = currentNode.val;
            if (currentNode.next != null && currentNode.next.val == value) {
                while (currentNode.next != null && currentNode.val == value) {
                    currentNode = currentNode.next;
                }
                if (currentNode.val == value) {
                    previousNode.next = null;
                } else {
                    previousNode.next = currentNode;
                }
            } else {
                previousNode = previousNode.next;
                currentNode = currentNode.next;
            }
        }
        this.head = dummyNode.next;
//        return dummyNode.next;
    }

    private class ListNode {
        private int val;
        private ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
