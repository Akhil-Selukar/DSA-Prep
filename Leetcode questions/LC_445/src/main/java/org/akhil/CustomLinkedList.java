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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        ListNode l1Reversed = reverseList(l1);
        ListNode l2Reversed = reverseList(l2);
        int carry = 0;

        while(l1Reversed != null || l2Reversed != null || carry != 0){
            int digit1 = l1Reversed == null ? 0 : l1Reversed.value;
            int digit2 = l2Reversed == null ? 0 : l2Reversed.value;

            int addition = digit1 + digit2 + carry;

            int ansDigit = addition%10;
            carry = addition/10;

            ListNode node = new ListNode(ansDigit);
            tail.next = node;
            tail = tail.next;

            l1Reversed = l1Reversed == null ? null : l1Reversed.next;
            l2Reversed = l2Reversed == null ? null : l2Reversed.next;
        }
        return reverseList(dummy.next);
    }

    private ListNode reverseList(ListNode head){
        ListNode previousNode = null;
        ListNode currentNode = head;
        ListNode nextNode = head.next;

        while(currentNode != null) {
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
            if (nextNode != null) {
                nextNode = nextNode.next;
            }
        }
        return previousNode;
    }

    private class ListNode{
        private int value;
        private ListNode next;

        public ListNode(int value){
            this.value = value;
        }
    }
}
