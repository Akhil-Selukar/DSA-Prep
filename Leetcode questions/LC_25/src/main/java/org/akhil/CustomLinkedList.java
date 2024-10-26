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

    public void reverseKGroup(int k) {
//        if(k == 1 || head == null){
//            return head;
//        }
        ListNode head = this.head;
        int size = findSize(head);
        int iterations = size/k;

        ListNode previousNode = null;
        ListNode currentNode = head;

        while(iterations > 0){
            ListNode lastNonReversed = previousNode;
            ListNode newEnd = currentNode;
            ListNode nextNode = currentNode.next;

            for(int i=0; currentNode != null && i<k; i++){
                currentNode.next = previousNode;
                previousNode = currentNode;
                currentNode = nextNode;
                if(nextNode != null){
                    nextNode = nextNode.next;
                }
            }

            if(lastNonReversed != null){
                lastNonReversed.next = previousNode;
            } else {
                this.head = previousNode;
            }

            newEnd.next = currentNode;
            previousNode = newEnd;
            iterations--;
        }
//        return head;
    }

    private int findSize(ListNode head) {
        if(head == null){
            return 0;
        }
        int counter = 0;
        while(head != null){
            counter++;
            head = head.next;
        }
        return counter;
    }

    private class ListNode{
        private int value;
        private ListNode next;

        public ListNode(int value){
            this.value = value;
        }
    }
}
