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
        this.tail = this.tail.next;
    }

    public void display(){
        ListNode temp = this.head;
        while(temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.print("END");
    }

    public void reorderList() {
        ListNode firstHead = this.head;
        ListNode midNode = findMiddle(this.head);           // finding the middle
        ListNode reversedListHead = reverseList(midNode);   // reversing the second half
        ListNode temp;

        // re-arranging the list
        while(firstHead != null && reversedListHead != null){
            temp = firstHead.next;
            firstHead.next = reversedListHead;
            firstHead = temp;

            temp = reversedListHead.next;
            reversedListHead.next = firstHead;
            reversedListHead = temp;
        }

        // setting tail.next = null;
        if(firstHead != null){
            firstHead.next = null;
        }
    }

    private ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode previousNode = null;
        ListNode currentNode = head;
        ListNode nextNode = head.next;
        while(currentNode != null){
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
            if(nextNode != null){
                nextNode = nextNode.next;
            }
        }
        return previousNode;
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private class ListNode{
        private int value;
        private ListNode next;

        public ListNode(int value){
            this.value = value;
        }
    }
}
