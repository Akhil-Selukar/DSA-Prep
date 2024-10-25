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
    }

    public boolean isPalindrome() {
        ListNode temp = this.head;
        ListNode middleNode = getMiddleNode(this.head);

        ListNode headOfReversed = reverseList(middleNode);

        while(temp !=null && headOfReversed != null ){
            if(temp.value != headOfReversed.value){
                return false;
            }
            temp = temp.next;
            headOfReversed = headOfReversed.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
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

    private ListNode getMiddleNode(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while(fastPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer;
    }

    private class ListNode{
        private int value;
        private ListNode next;

        public ListNode(int value){
            this.value = value;
        }
    }
}
